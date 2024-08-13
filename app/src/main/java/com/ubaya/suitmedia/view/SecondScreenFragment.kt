package com.ubaya.suitmedia.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.suitmedia.R
import com.ubaya.suitmedia.viewmodel.SecondScreenViewModel

class SecondScreenFragment : Fragment() {

    companion object {
        fun newInstance() = SecondScreenFragment()
    }

    private lateinit var viewModel: SecondScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}