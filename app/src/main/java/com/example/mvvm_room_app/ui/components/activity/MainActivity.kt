package com.example.mvvm_room_app.ui.components.activity

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.mvvm_room_app.R
import com.example.mvvm_room_app.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    private var mNavHostFragment : NavHostFragment? = null

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViews(savedInstanceState: Bundle?) {
        // this Activity is not being recreated
        if(savedInstanceState == null) {
            initNavHostFragment()
        }
    }

    override fun initData() {

    }

    private fun initNavHostFragment(){
        runOnUiThread {
            if(mNavHostFragment == null){
                mNavHostFragment = NavHostFragment.create(R.navigation.my_nav)
                supportFragmentManager.beginTransaction()
                    .add(R.id.nav_main_fragment, mNavHostFragment!!)
                    .setPrimaryNavigationFragment(mNavHostFragment)
                    .commit()
            }
        }
    }
}