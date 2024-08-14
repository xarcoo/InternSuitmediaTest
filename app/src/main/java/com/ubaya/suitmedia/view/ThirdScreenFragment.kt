package com.ubaya.suitmedia.view

import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.suitmedia.R
import com.ubaya.suitmedia.databinding.FragmentThirdScreenBinding
import com.ubaya.suitmedia.model.User
import com.ubaya.suitmedia.viewmodel.ThirdScreenViewModel

class ThirdScreenFragment : Fragment() {
    private lateinit var binding: FragmentThirdScreenBinding
    private lateinit var viewModel: ThirdScreenViewModel

    private lateinit var sharedPreferences: SharedPreferences
//    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
    private lateinit var userListAdapter: UserAdapter

    companion object {
        fun newInstance() = ThirdScreenFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        userListAdapter = UserAdapter(arrayListOf<User>(), sharedPreferences)

        viewModel = ViewModelProvider(this).get(ThirdScreenViewModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = userListAdapter

        observeViewModel()

        binding.refreshLayout.setOnRefreshListener {
            binding.recView.visibility = View.GONE
            binding.txtEmpty.visibility = View.GONE
            binding.progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            binding.refreshLayout.isRefreshing = false
        }
    }

    private fun observeViewModel() {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            userListAdapter.updateUserList(it)
        })

        viewModel.emptyLoadLD.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                binding.txtEmpty?.visibility = View.VISIBLE
            } else {
                binding.txtEmpty?.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                binding.recView.visibility = View.GONE
                binding.progressLoad.visibility = View.VISIBLE
            } else {
                binding.recView.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.GONE
            }
        })
    }
}