package com.danielleitelima.bottomsheetfragmenttest

import android.os.Bundle
import com.danielleitelima.bottomsheetfragmenttest.BottomSheetFragment
import com.danielleitelima.bottomsheetfragmenttest.base.BaseActivity
import com.danielleitelima.bottomsheetfragmenttest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        buttonBottomSheetDialogFragment.setOnClickListener{
            showBottomSheetDialogFragment()
        }
    }

    private fun showBottomSheetDialogFragment() {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }
}
