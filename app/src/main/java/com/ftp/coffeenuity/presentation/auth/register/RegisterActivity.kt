package com.ftp.coffeenuity.presentation.auth.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.ActivityRegisterBinding
import com.ftp.coffeenuity.domain.model.User
import com.ftp.coffeenuity.presentation.MainActivity
import com.ftp.coffeenuity.presentation.auth.AuthViewModel
import com.google.firebase.auth.AuthResult
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!
    private val authViewModel: AuthViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initClick()
    }

    private fun initClick() {
        with(binding) {
            btnRegister.setOnClickListener {
                authViewModel.register(
                    tilEmail.editText?.text.toString(),
                    tilPassword.editText?.text.toString()
                ).observe(this@RegisterActivity) {
                    when (it) {
                        is Resource.Loading -> {
                            binding.btnRegister.showLoading()
                        }
                        is Resource.Success -> {
                            addUser(it.data)
                        }
                        is Resource.Error -> {
                            binding.btnRegister.hideLoading()
                        }
                    }
                }
            }
        }
    }

    private fun addUser(data: AuthResult?) {
        val user = User(
            idUser = data?.user?.uid.toString(),
            email = binding.tilEmail.editText?.text.toString(),
            role = binding.tilPekerjaan.editText?.text.toString(),
            nama = binding.tilName.editText?.text.toString(),
            jenisKelamin = binding.tilJenisKelamin.editText?.text.toString(),
            usia = binding.tilUsia.editText?.text.toString(),
            address = binding.tilAlamat.editText?.text.toString(),
            sifatUsaha = binding.tilSifatUsaha.editText?.text.toString(),
            kepemilikanLahan = binding.tilKepemilikanLahan.editText?.text.toString(),
            luasLahan = binding.tilLuasLahan.editText?.text.toString(),
            pengalamanUsahaTani = binding.tilPengalamanUsahaTani.editText?.text.toString(),
            jumlahTenagaKerja = binding.tilJumlahTenagaKerja.editText?.text.toString(),
            produkYangDijual = binding.tilProdukYangDijual.editText?.text.toString(),
            rangeHargaProduk = binding.tilRangeHargaProduk.editText?.text.toString()
        )
        authViewModel.addUser(user).observe(this@RegisterActivity) {
            when (it) {
                is Resource.Loading -> {
                    binding.btnRegister.showLoading()
                }
                is Resource.Success -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    binding.btnRegister.hideLoading()
                }
                is Resource.Error -> {
                    binding.btnRegister.hideLoading()
                }
            }
        }
    }
}