package cn.lancet.viewmodel

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import cn.lancet.viewmodel.databinding.ActivityPhoneNumberInputBinding

class PhoneNumberInputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhoneNumberInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityPhoneNumberInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val phoneViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[PhoneViewModel::class.java]

        binding.phoneViewModel = phoneViewModel
        binding.etInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                phoneViewModel.notifyPropertyChanged(BR.phoneNo)
            }

        })

    }

}