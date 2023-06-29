package com.example.socialnetworkusers.presentation.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.fragment.findNavController
import com.example.socialnetworkusers.databinding.FragmentUsersListBinding
import com.example.socialnetworkusers.presentation.ui.adapters.UserEntityItemAdapter
import com.example.socialnetworkusers.presentation.ui.viewmodels.UserListViewModel


class UsersListFragment : Fragment() {
    private var _binding: FragmentUsersListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserListViewModel = UserListViewModel()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentUsersListBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.getUserListFromApi()


        val adapter = UserEntityItemAdapter(requireContext()) { userEntityFromApiResponse ->
            viewModel.onUserClicked(
                userEntityFromApiResponse
            )
        }

        binding.listOfUsersRecycler.adapter = adapter

        viewModel.usersList.observe(viewLifecycleOwner) {
            it?.let { adapter.submitList(it) }
        }

        viewModel.navigateToUserDetails.observe(viewLifecycleOwner) { userEntity ->
            userEntity?.let {
                val action = UsersListFragmentDirections.actionUsersListFragmentToUserPostsFragment(
                    userEntity
                )
                this.findNavController().navigate(action)
                viewModel.onUserNavigated()

            }
        }



        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}