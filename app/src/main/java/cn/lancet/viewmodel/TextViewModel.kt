package cn.lancet.viewmodel

import androidx.lifecycle.ViewModel

/**
 * Created by Lancet at 2022/8/18 09:50
 */
class TextViewModel : ViewModel() {

    var content: String = ""

    override fun toString(): String {
        return "TextViewModel(content='$content')"
    }

}