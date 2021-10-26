package com.ftp.coffeenuity.presentation.home.questioner.strategi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ftp.coffeenuity.adapter.StrategiAdapter
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.data.staticdata.StrategiData
import com.ftp.coffeenuity.databinding.FragmentStrategiBinding
import com.ftp.coffeenuity.utils.Constants

class StrategiFragment : Fragment() {

    private var _binding: FragmentStrategiBinding? = null
    private val binding get() = _binding!!
    private val args: StrategiFragmentArgs by navArgs()
    private lateinit var strategiEkonomiAdapter: StrategiAdapter
    private lateinit var strategiSosialAdapter: StrategiAdapter
    private lateinit var strategiLingkunganAdapter: StrategiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStrategiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        initClick()
    }

    private fun initClick() {
        binding.btnBack.setOnClickListener{
            requireActivity().onBackPressed()
        }
    }

    private fun setupAdapter() {
        val response = args.response
        strategiEkonomiAdapter = StrategiAdapter()
        strategiSosialAdapter = StrategiAdapter()
        strategiLingkunganAdapter = StrategiAdapter()
        val strategiEkonomi = StrategiData.getStrategi(
            aktor = ProfilePrefs.role,
            kategori = response.indeksBerkelanjutan.ekonomi.kategori,
            variabel = Constants.EKONOMI
        )
        val strategiSosial = StrategiData.getStrategi(
            aktor = ProfilePrefs.role,
            kategori = response.indeksBerkelanjutan.sosial.kategori,
            variabel = Constants.SOSIAL
        )
        val strategiLingkungan = StrategiData.getStrategi(
            aktor = ProfilePrefs.role,
            kategori = response.indeksBerkelanjutan.lingkungan.kategori,
            variabel = Constants.LINGKUNGAN
        )
        strategiEkonomi?.strategi?.let { strategiEkonomiAdapter.submitList(it) }
        strategiSosial?.strategi?.let { strategiSosialAdapter.submitList(it) }
        strategiLingkungan?.strategi?.let { strategiLingkunganAdapter.submitList(it) }
        with(binding) {
            rvStrategiEkonomi.adapter = strategiEkonomiAdapter
            rvStrategiSosial.adapter = strategiSosialAdapter
            rvStrategiLingkungan.adapter = strategiLingkunganAdapter
        }
    }
}