package com.ubaya.suitmedia.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.suitmedia.R
import com.ubaya.suitmedia.viewmodel.FirstScreenViewModel

class FirstScreenFragment : Fragment() {

    companion object {
        fun newInstance() = FirstScreenFragment()
    }

    private lateinit var viewModel: FirstScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_screen, container, false)
    }
}