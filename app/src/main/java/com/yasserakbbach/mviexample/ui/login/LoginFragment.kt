package com.yasserakbbach.mviexample.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yasserakbbach.mviexample.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private var binding: LoginFragmentBinding? = null
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = LoginFragmentBinding.inflate(inflater, container, false)
        .also { binding = it }
        .root

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}