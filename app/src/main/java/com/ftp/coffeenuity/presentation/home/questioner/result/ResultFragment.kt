package com.ftp.coffeenuity.presentation.home.questioner.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ftp.coffeenuity.R
import com.ftp.coffeenuity.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initClick()
    }

    private fun initView() {
        val response = args.response
        with(binding) {
            val indeksEkonomi =
                "${response.indeksBerkelanjutan.ekonomi.indeksBerkelanjutan * 100}".take(4) + " %"
            tvKategoriEkonomi.text = response.indeksBerkelanjutan.ekonomi.kategori
            tvIndeksKeberlanjutanEkonomi.text = indeksEkonomi

            val indeksSosial =
                "${response.indeksBerkelanjutan.sosial.indeksBerkelanjutan * 100}".take(4) + " %"
            tvKategoriSosial.text = response.indeksBerkelanjutan.sosial.kategori
            tvIndeksKeberlanjutanSosial.text = indeksSosial

            val indeksLingkungan =
                "${response.indeksBerkelanjutan.lingkungan.indeksBerkelanjutan * 100}".take(4) + " %"
            tvKategoriLingkungan.text = response.indeksBerkelanjutan.lingkungan.kategori
            tvIndeksKeberlanjutanLingkungan.text = indeksLingkungan

            val rataRataIndeksGeometri =
                ( ((response.indeksBerkelanjutan.ekonomi.indeksBerkelanjutan) +
                        (response.indeksBerkelanjutan.sosial.indeksBerkelanjutan) +
                        (response.indeksBerkelanjutan.lingkungan.indeksBerkelanjutan)) / 3) * 100

            val rataRataIndeksGeometriString =
                "$rataRataIndeksGeometri".take(4) + " %"

            tvRataRataIndeksGeometri.text = rataRataIndeksGeometriString
        }
    }

    private fun initClick() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_strategiFragment)
        }
    }

}