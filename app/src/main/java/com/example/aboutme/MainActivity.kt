package com.example.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.done.setOnClickListener {
            addNickName(it)
        }
//        findViewById<Button>(R.id.done).setOnClickListener {
//            addNickName(it)
//        }


    }

    private fun addNickName(view: View) {
//        val editText : EditText = findViewById(R.id.editText)
//        val done_btn : Button = findViewById(R.id.done)
//        val nickText : TextView = findViewById(R.id.nick_name)

        binding.apply {
            nickName.text = binding.editText.text

            editText.visibility = View.GONE
            view.visibility = View.GONE
            nickName.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }
}