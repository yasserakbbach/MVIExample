package com.yasserakbbach.mviexample.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yasserakbbach.mviexample.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {

    private var binding: ProfileFragmentBinding? = null
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ProfileFragmentBinding.inflate(inflater, container, false)
        .also { binding = it }
        .root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}