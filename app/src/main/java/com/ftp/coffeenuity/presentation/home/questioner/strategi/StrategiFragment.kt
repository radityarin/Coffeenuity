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

        when(ProfilePrefs.role){
            Constants.PETANI->{
                with(binding){
                    tvBiayaProduksi.text = args.petani?.editText1
                    tvPasarProduksi.text = args.petani?.editText7
                    tvJumlahProduksi.text = args.petani?.editText3
                    tvJenisGrade.text = convertToGradeNumber(args.petani?.checkBox8.toString())
                    tvHasilProduksi.text = args.petani?.editText2
                    tvHasilSosial.text = args.response.indeksBerkelanjutan.sosial.kategori
                    tvHasilEkonomi.text = args.response.indeksBerkelanjutan.ekonomi.kategori
                    tvHasilLingkungan.text = args.response.indeksBerkelanjutan.lingkungan.kategori
                }
            }
            Constants.ROASTERY->{
                with(binding){
                    tvBiayaProduksi.text = args.roastery?.editText1
                    tvPasarProduksi.text = args.roastery?.editText8
                    tvJumlahProduksi.text = args.roastery?.editText3
                    tvJenisGrade.visibility = View.GONE
                    tvTitleJenisGrade.visibility = View.GONE
                    tvHasilProduksi.text = args.roastery?.editText2
                    tvHasilSosial.text = args.response.indeksBerkelanjutan.sosial.kategori
                    tvHasilEkonomi.text = args.response.indeksBerkelanjutan.ekonomi.kategori
                    tvHasilLingkungan.text = args.response.indeksBerkelanjutan.lingkungan.kategori
                }
            }
            Constants.TENGKULAK->{
                with(binding){
                    tvTitleBiayaProduksi.visibility = View.GONE
                    tvBiayaProduksi.visibility = View.GONE
                    tvPasarProduksi.text = args.tengkulak?.editText4
                    tvTitleJumlahProduksi.visibility = View.GONE
                    tvJumlahProduksi.visibility = View.GONE
                    tvTitleHasilProduksi.visibility = View.GONE
                    tvHasilProduksi.visibility = View.GONE
                    tvJenisGrade.text = convertToGradeNumber(args.tengkulak?.checkBox7.toString())
                    tvHasilSosial.text = args.response.indeksBerkelanjutan.sosial.kategori
                    tvHasilEkonomi.text = args.response.indeksBerkelanjutan.ekonomi.kategori
                    tvHasilLingkungan.text = args.response.indeksBerkelanjutan.lingkungan.kategori
                }
            }
        }
    }

    private fun convertToGradeNumber(toString: String): String {
        val listGrade = toString.split(",").dropLast(1)
        var grade = ""
        listGrade.forEachIndexed { index, s ->
            if (s == "true"){
                grade += "Grade ${index + 1}, "
            }
        }
        return grade
    }
}