package cn.lancet.viewmodel

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import cn.lancet.viewmodel.databinding.FragmentTopBinding



class TopFragment : Fragment() {

    private var mBinding:FragmentTopBinding?=null
    private var mEditText:AppCompatEditText?=null

    private var mViewModel:TextViewModel?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTopBinding.inflate(inflater, container,false)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mEditText = mBinding!!.editText

        mViewModel = ViewModelProvider(requireActivity(),ViewModelProvider.NewInstanceFactory())[TextViewModel::class.java]

        mEditText?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                mViewModel!!.content = s.toString()
            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mEditText = null
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}