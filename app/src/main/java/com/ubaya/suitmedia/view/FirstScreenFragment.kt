package com.ubaya.suitmedia.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.ubaya.suitmedia.R
import com.ubaya.suitmedia.databinding.FragmentFirstScreenBinding
import com.ubaya.suitmedia.viewmodel.FirstScreenViewModel

class FirstScreenFragment : Fragment() {
    private lateinit var binding: FragmentFirstScreenBinding

    companion object {
        fun newInstance() = FirstScreenFragment()
    }

    private lateinit var viewModel: FirstScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCheck.setOnClickListener {
            val input = binding.txtPalindrome.text.toString()

            if (isPalindrome(input)) Toast.makeText(requireContext(), "isPalindrome", Toast.LENGTH_SHORT).show()
            else Toast.makeText(requireContext(), "Not Palindrome", Toast.LENGTH_SHORT).show()
        }

        binding.btnNext.setOnClickListener {
            val name = binding.txtName.text.toString()
            val action = FirstScreenFragmentDirections.actionFirst()
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
            sharedPreferences.edit().putString("name", name).apply()

            Navigation.findNavController(it).navigate(action)
        }
    }

    fun isPalindrome(text: String): Boolean {
        val palindrome = text.replace(" ", "").toLowerCase()

        return palindrome == palindrome.reversed()
    }
}