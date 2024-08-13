package com.ubaya.suitmedia.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.suitmedia.R
import com.ubaya.suitmedia.databinding.FragmentThirdScreenBinding
import com.ubaya.suitmedia.viewmodel.ThirdScreenViewModel

class ThirdScreenFragment : Fragment() {
    private lateinit var binding: FragmentThirdScreenBinding

    companion object {
        fun newInstance() = ThirdScreenFragment()
    }

    private lateinit var viewModel: ThirdScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}