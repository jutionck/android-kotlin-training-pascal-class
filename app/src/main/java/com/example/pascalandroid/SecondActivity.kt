package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val GET_NAME = "get_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btn_back_to_parent.setOnClickListener(this)
        tv_hello_name.text = intent.getStringExtra(GET_NAME)
    }

    override fun onClick(v: View?) {
        when(v) {
            btn_back_to_parent -> finish()
        }
    }


}