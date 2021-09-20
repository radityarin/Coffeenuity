package com.ftp.coffeenuity.presentation.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.ActivityLoginBinding
import com.ftp.coffeenuity.presentation.MainActivity
import com.ftp.coffeenuity.presentation.admin.AdminMainActivity
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
                if (tilEmail.editText?.text.toString() == "admin6@system.com" && tilPassword.editText?.text.toString() == "Pass123!") {
                    startActivity(Intent(this@LoginActivity, AdminMainActivity::class.java))
                } else {
                    authViewModel.login(
                        tilEmail.editText?.text.toString(),
                        tilPassword.editText?.text.toString()
                    ).observe(this@LoginActivity) {
                        when (it) {
                            is Resource.Loading -> {
                                binding.btnLogin.showLoading()
                            }
                            is Resource.Success -> {
                                ProfilePrefs.idFirebase = it.data?.user?.uid.toString()
                                getCurrentUserData()
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

    private fun getCurrentUserData() {
        authViewModel.getUserWithIDUser(ProfilePrefs.idFirebase).observe(this) {
            when (it) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    val user = it.data
                    if (user != null) {
                        ProfilePrefs.apply {
                            fullname = user.nama
                            role = user.role
                            alamat = user.pengalamanUsahaTani
                            usia = user.usia
                            jumlahTenagaKerja = user.jumlahTenagaKerja
                            sifatUsaha = user.sifatUsaha
                            jenisKelamin = user.jenisKelamin
                        }
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }
                }
                else -> println("Error")
            }
        }

    }
}