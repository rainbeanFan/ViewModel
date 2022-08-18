package cn.lancet.viewmodel

import androidx.lifecycle.ViewModel

/**
 * Created by Lancet at 2022/8/17 22:28
 */
class StartTimeViewModel: ViewModel() {

    private var mCurrentTime: Long = 0L

    fun fetchCurrentTimeMillis(onStartTimeFetchedListener: OnStartTimeFetchedListener){
        if (mCurrentTime == 0L){
            mCurrentTime = System.currentTimeMillis()
        }
        onStartTimeFetchedListener.onStartTimeFetched(mCurrentTime)
    }

    interface OnStartTimeFetchedListener {
        fun onStartTimeFetched(currentTimeMillis: Long)
    }

}