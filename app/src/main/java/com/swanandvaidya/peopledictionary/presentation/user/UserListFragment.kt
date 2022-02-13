package com.swanandvaidya.peopledictionary.presentation.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.swanandvaidya.peopledictionary.R
import com.swanandvaidya.peopledictionary.databinding.FragmentUserListBinding
import com.swanandvaidya.peopledictionary.adapters.UserListAdapter
import com.swanandvaidya.peopledictionary.viewmodels.userlist.UserListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private val userListAdapter = UserListAdapter()
    private val userViewModel: UserListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        setUpObservables()
        addUser()
    }

    private fun addUser() {
        binding.fabAddUser.setOnClickListener {
            findNavController().navigate(R.id.action_userListFragment_to_userDetailFragment)
        }
    }

    private fun setUpRecyclerView() {
        binding.rvUser.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userListAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    (this.layoutManager as LinearLayoutManager).orientation
                )
            )
        }
    }

    private fun setUpObservables() {
        userViewModel.userList.observe(this, {
            if (it.isEmpty()) {
                binding.tvNoData.isVisible = true
                binding.rvUser.isVisible = false
            } else {
                binding.tvNoData.isVisible = false
                binding.rvUser.isVisible = true
                userListAdapter.submitUserList(it)
            }
        })
    }

}