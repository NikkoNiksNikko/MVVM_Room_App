package com.example.mvvm_room_app.ui.base

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import java.lang.ref.WeakReference

abstract class BaseFragment : Fragment() {

    private lateinit var mViewGroupIsSet: WeakReference<Boolean>
    private var mViewGroup: ViewGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewGroupIsSet = WeakReference(true)

        container?.let {
            if(mViewGroup == null){
                mViewGroup = inflater.inflate(setLayoutId(),container,false) as ViewGroup
                mViewGroupIsSet = WeakReference(false)
            }

            // Inflate the layout for this fragment
            return mViewGroup
        }
        return null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(!mViewGroupIsSet.get()!!){
            initViews(savedInstanceState)
        }
        initData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        Toast.makeText(this.context, "onDestroyView", Toast.LENGTH_SHORT).show()
    }

    abstract fun setLayoutId(): Int
    abstract fun initViews(savedInstanceState: Bundle?)
    abstract fun initData()
}