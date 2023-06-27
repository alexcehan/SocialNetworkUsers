package com.example.socialnetworkusers.presentation.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.socialnetworkusers.R
import com.example.socialnetworkusers.databinding.FragmentUserPostsBinding
import com.example.socialnetworkusers.presentation.ui.viewmodels.UserPostsViewModel


class UserPostsFragment : Fragment() {
    private var _binding: FragmentUserPostsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserPostsViewModel = UserPostsViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserPostsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.userEntity = UserPostsFragmentArgs.fromBundle(requireArguments()).userEntity
        viewModel.getUserFirstPost()






        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}