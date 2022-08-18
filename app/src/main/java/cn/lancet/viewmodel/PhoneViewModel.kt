package cn.lancet.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel

/**
 * Created by Lancet at 2022/8/18 10:23
 */
class PhoneViewModel : ViewModel(), Observable {

    private var mCallbacks = PropertyChangeRegistry()
    private var mPhoneNO = ""

    @Bindable
    fun getPhoneNo() = mPhoneNO

    fun setPhoneNo(phoneNo: String) {
        mPhoneNO = phoneNo
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.remove(callback)
    }

    fun notifyChange() {
        mCallbacks.notifyCallbacks(this, 0, null)
    }

    fun notifyPropertyChanged(fieldId: Int) {
        mCallbacks.notifyCallbacks(this, fieldId, null)
    }

}