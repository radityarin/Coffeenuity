package com.ftp.coffeenuity.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.databinding.FragmentProfileBinding
import com.ftp.coffeenuity.presentation.auth.AuthViewModel
import com.ftp.coffeenuity.presentation.auth.onboarding.OnBoardingActivity
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val authViewModel: AuthViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
        observe()
    }

    private fun observe() {
        authViewModel.getUserWithIDUser(ProfilePrefs.idFirebase).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    with(binding) {
                        tvName.text = ProfilePrefs.fullname
                        tvPekerjaan.text = ProfilePrefs.role
                        tvAlamat.text = ProfilePrefs.alamat
                        tvUsia.text = ProfilePrefs.usia + " Tahun"
                        tvJumlahTenagaKerja.text = ProfilePrefs.jumlahTenagaKerja
                        tvSifatUsaha.text = ProfilePrefs.sifatUsaha
                        tvJenisKelamin.text = ProfilePrefs.jenisKelamin
                    }
                }
                is Resource.Success -> {
                    val user = it.data
                    if (user != null) {
                        with(binding) {
                            tvName.text = user.nama
                            tvPekerjaan.text = user.role
                            tvAlamat.text = user.address
                            tvUsia.text = user.usia + " Tahun"
                            tvJumlahTenagaKerja.text = user.jumlahTenagaKerja
                            tvSifatUsaha.text = user.sifatUsaha
                            tvJenisKelamin.text = user.jenisKelamin

                            ProfilePrefs.apply {
                                fullname = user.nama
                                role = user.role
                                alamat = user.pengalamanUsahaTani
                                usia = user.usia
                                jumlahTenagaKerja = user.jumlahTenagaKerja
                                sifatUsaha = user.sifatUsaha
                                jenisKelamin = user.jenisKelamin
                            }
                        }
                    }

                }
                else -> println("Error")
            }
        }
    }

    private fun initClick() {
        binding.btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(
                Intent(activity, OnBoardingActivity::class.java)
            )
            ProfilePrefs.idFirebase = ""
            activity?.finishAffinity()
        }
    }
}