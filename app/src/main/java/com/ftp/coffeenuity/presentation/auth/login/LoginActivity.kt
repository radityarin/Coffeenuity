package com.ftp.coffeenuity.presentation.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.ActivityLoginBinding
import com.ftp.coffeenuity.presentation.MainActivity
import com.ftp.coffeenuity.presentation.auth.AuthViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    private val authViewModel: AuthViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initClick()
    }

    private fun initClick() {
        with(binding) {
            btnLogin.setOnClickListener {
                authViewModel.login(
                    tilEmail.editText?.text.toString(),
                    tilPassword.editText?.text.toString()
                ).observe(this@LoginActivity) {
                    when (it) {
                        is Resource.Loading -> {
                            binding.btnLogin.showLoading()
                        }
                        is Resource.Success -> {
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            binding.btnLogin.hideLoading()
                        }
                        is Resource.Error -> {
                            binding.btnLogin.hideLoading()
                        }
                    }
                }
            }
        }
    }
}