package com.yasserakbbach.mviexample.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yasserakbbach.mviexample.databinding.LoginFragmentBinding
import kotlinx.coroutines.flow.collect

class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Whenever the view is resumed, subscribe to our ViewModel's view state StateFlow
        lifecycleScope.launchWhenResumed {
            viewModel.viewState.collect { viewState ->
                processViewState(viewState)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = LoginFragmentBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    /**
     * Whenever a relevant UI action occurs like a text change or a button click, proxy that
     * to the view model to handle.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            signInButton.setOnClickListener {
                viewModel.signInButtonClicked()
            }

            emailInput.doAfterTextChanged {
                viewModel.emailChanged(it.toString())
            }

            passwordInput.doAfterTextChanged {
                viewModel.passwordChanged(it.toString())
            }
        }

    }

    private fun processViewState(viewState: LoginViewState) {
        binding.apply {
            progressBar.isVisible = viewState.showProgressBar
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}