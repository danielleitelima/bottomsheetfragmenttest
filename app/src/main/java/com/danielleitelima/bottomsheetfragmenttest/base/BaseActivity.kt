package com.danielleitelima.bottomsheetfragmenttest.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.danielleitelima.bottomsheetfragmenttest.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}
