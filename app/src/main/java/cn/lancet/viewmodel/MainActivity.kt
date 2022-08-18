package cn.lancet.viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import cn.lancet.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private var mCurrentTimeMillis: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding!!.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.top_fragment,TopFragment())
            .commitNow()

        supportFragmentManager.beginTransaction()
            .replace(R.id.bottom_fragment,BottomFragment())
            .commitNow()

        mBinding!!.tvTime.setOnClickListener {
            startActivity(Intent(this,PhoneNumberInputActivity::class.java))
        }

        initData()

    }

    private fun initData() {
        mCurrentTimeMillis = System.currentTimeMillis()

        val startTimeViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[StartTimeViewModel::class.java]

        startTimeViewModel.fetchCurrentTimeMillis(object :
            StartTimeViewModel.OnStartTimeFetchedListener {
            override fun onStartTimeFetched(currentTimeMillis: Long) {
                mBinding!!.tvTime.text = currentTimeMillis.toString()

            }

        })

    }

}