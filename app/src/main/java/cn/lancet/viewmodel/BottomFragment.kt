package cn.lancet.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProvider
import cn.lancet.viewmodel.databinding.FragmentBottomBinding
import com.google.android.material.button.MaterialButton


class BottomFragment : Fragment() {

    private var mBinding:FragmentBottomBinding?=null
    private var mTextView:AppCompatTextView?=null
    private var mButton: AppCompatButton?=null

    private var mViewModel:TextViewModel?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentBottomBinding.inflate(inflater, container,false)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTextView = mBinding!!.textView
        mButton = mBinding!!.button

        mViewModel = ViewModelProvider(requireActivity(),ViewModelProvider.NewInstanceFactory())[TextViewModel::class.java]

        mButton?.setOnClickListener {
            mTextView?.text = mViewModel!!.content
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mTextView = null
        mButton = null
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}