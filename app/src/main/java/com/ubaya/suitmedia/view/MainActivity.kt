package com.ubaya.suitmedia.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ubaya.suitmedia.R
import com.ubaya.suitmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }
}