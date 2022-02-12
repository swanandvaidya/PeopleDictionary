package com.swanandvaidya.peopledictionary.presentation.userdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.swanandvaidya.peopledictionary.R
import com.swanandvaidya.peopledictionary.databinding.FragmentUserDetailBinding
import com.swanandvaidya.peopledictionary.presentation.userdetail.viewmodel.UserDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private lateinit var binding: FragmentUserDetailBinding
    private val userDetailViewModel: UserDetailViewModel by viewModels()
    private lateinit var userName: String
    private lateinit var mobileNumber: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // perform fab action click
        performAction()

        // save user into database
        setUpObservables()

    }

    private fun performAction() {
        binding.btnSaveUser.setOnClickListener {
            userDetailViewModel.validateUser(binding.etUsername.text.toString(), binding.etMobileNumber.text.toString() )
        }

    }

    private fun setUpObservables() {
        userDetailViewModel.isValidUser.observe(this, {
            when(it) {
                true -> {
                    userName = binding.etUsername.text.toString()
                    mobileNumber = binding.etMobileNumber.text.toString()
                    userDetailViewModel.saveUser(userName, mobileNumber)
                    findNavController().navigate(R.id.action_userDetailFragment_to_userListFragment)
                }

                false -> {
                    showError()
                }
            }
        })
    }

    private fun showError() {
        Snackbar.make(
            requireView(),
            getString(R.string.text_error_invalid_user),
            Snackbar.LENGTH_SHORT
        ).show()
    }
}