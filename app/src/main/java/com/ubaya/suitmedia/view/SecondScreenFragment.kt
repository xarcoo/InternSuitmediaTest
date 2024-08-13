package com.ubaya.suitmedia.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.suitmedia.R
import com.ubaya.suitmedia.databinding.FragmentSecondScreenBinding

class SecondScreenFragment : Fragment() {
    private lateinit var binding: FragmentSecondScreenBinding

    companion object {
        fun newInstance() = SecondScreenFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val name = sharedPreferences.getString("name", "")
        binding.txtNameShow.text = name

        var selectedName = sharedPreferences.getString("selectedName", "Selected User Name")
        binding.txtSelectedUserName.text = selectedName

        binding.btnChoose.setOnClickListener {
            val action = SecondScreenFragmentDirections.actionSecond()

            Navigation.findNavController(it).navigate(action)
        }
    }
}