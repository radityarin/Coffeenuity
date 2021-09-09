package com.ftp.coffeenuity.presentation.auth.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.ftp.coffeenuity.R
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.ActivityRegisterBinding
import com.ftp.coffeenuity.domain.model.User
import com.ftp.coffeenuity.presentation.MainActivity
import com.ftp.coffeenuity.presentation.auth.AuthViewModel
import com.ftp.coffeenuity.utils.Constants
import com.ftp.coffeenuity.utils.UtilsView.snackErrorText
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
        setupSpinner()
    }

    private fun setupLayout(jobsType: String) {
        with(binding) {
            cvKepemilikanLahan.visibility = View.GONE
            cvLuasLahan.visibility = View.GONE
            cvPengalamanUsahaTani.visibility = View.GONE
            cvRangeHargaProduk.visibility = View.GONE
            cvProdukYangDijual.visibility = View.GONE
            when (jobsType) {
                Constants.PETANI -> {
                    cvKepemilikanLahan.visibility = View.VISIBLE
                    cvLuasLahan.visibility = View.VISIBLE
                    cvPengalamanUsahaTani.visibility = View.VISIBLE
                }
                Constants.TENGKULAK -> {
                    cvRangeHargaProduk.visibility = View.VISIBLE
                }
                Constants.ROASTERY -> {
                    cvRangeHargaProduk.visibility = View.VISIBLE
                    cvProdukYangDijual.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setupSpinner() {
        val jobs = mutableListOf(
            "Pilih Pekerjaan",
            Constants.PETANI,
            Constants.TENGKULAK,
            Constants.ROASTERY
        )
        val gender = mutableListOf(
            "Pilih Jenis Kelamin",
            "Laki-laki",
            "Perempuan"
        )
        val aaJobs: ArrayAdapter<String>? =
            ArrayAdapter(
                applicationContext, R.layout.spinner_pekerjaan_item,
                jobs
            )
        val aaGender: ArrayAdapter<String>? =
            ArrayAdapter(
                applicationContext, R.layout.spinner_pekerjaan_item,
                gender
            )
        aaJobs?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        aaGender?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        with(binding) {
            spnPekerjaan.adapter = aaJobs
            spnJenisKelamin.adapter = aaGender
            spnPekerjaan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    setupLayout(spnPekerjaan.selectedItem.toString())
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        }
    }

    private fun initClick() {
        with(binding) {
            btnRegister.setOnClickListener {
                if (formValidation()) {
                    register()
                }
            }
        }
    }

    private fun formValidation(): Boolean {
        if (binding.spnPekerjaan.selectedItemPosition == 0) {
            binding.spnPekerjaan.snackErrorText("Pilih Pekerjaan")
            return false
        }
        if (binding.spnJenisKelamin.selectedItemPosition == 0) {
            binding.spnJenisKelamin.snackErrorText("Pilih Jenis Kelamin")
            return false
        }
        return true
    }

    private fun register() {
        with(binding) {
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

    private fun addUser(data: AuthResult?) {
        val user = User(
            idUser = data?.user?.uid.toString(),
            email = binding.tilEmail.editText?.text.toString(),
            role = binding.spnPekerjaan.selectedItem.toString(),
            nama = binding.tilName.editText?.text.toString(),
            jenisKelamin = binding.spnJenisKelamin.selectedItem.toString(),
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
                    ProfilePrefs.idFirebase = data?.user?.uid.toString()
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