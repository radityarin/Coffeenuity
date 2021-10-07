package com.ftp.coffeenuity.presentation.home.questioner.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ftp.coffeenuity.databinding.FragmentResultBinding
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
import android.util.SparseIntArray
import com.ftp.coffeenuity.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.utils.ViewPortHandler
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.components.YAxis

import com.github.mikephil.charting.components.AxisBase

import com.github.mikephil.charting.formatter.IAxisValueFormatter

import com.github.mikephil.charting.components.XAxis





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
        setupRadarChart()
    }

    private fun setupRadarChart() {
        val response = args.response
        val factors = SparseIntArray(3)
        val scores = SparseIntArray(3)
        val entries: ArrayList<RadarEntry> = ArrayList()
        val dataSets: ArrayList<IRadarDataSet> = ArrayList()

        factors.append(1, R.string.ekonomi);
        factors.append(2, R.string.lingkungan);
        factors.append(3, R.string.sosial);

        val xAxis: XAxis = binding.RadarChart.getXAxis()
        xAxis.xOffset = 0f
        xAxis.yOffset = 0f
        xAxis.textSize = 16f
        xAxis.valueFormatter = object : IAxisValueFormatter {
            private val mFactors = arrayOf(
                getString(factors[1]), getString(factors[2]),
                getString(factors[3])
            )

            override fun getFormattedValue(value: Float, axis: AxisBase): String {
                return mFactors[value.toInt() % mFactors.size]
            }
        }

        val yAxis: YAxis = binding.RadarChart.getYAxis()
        yAxis.axisMinimum = 0f
        yAxis.axisMaximum = 50f
        yAxis.textSize = 0f
        yAxis.setLabelCount(3, false)
        yAxis.setDrawLabels(false)

        scores.append(1, (response.indeksBerkelanjutan.ekonomi.indeksBerkelanjutan * 100).toInt());
        scores.append(2, (response.indeksBerkelanjutan.sosial.indeksBerkelanjutan * 100).toInt());
        scores.append(3, (response.indeksBerkelanjutan.lingkungan.indeksBerkelanjutan * 100).toInt());
        entries.clear()

        for (i in 1..3) {
            entries.add(RadarEntry(scores[i].toFloat()))
        }

        val dataSet = RadarDataSet(entries, "")
        dataSet.color = R.color.primaryPurple
        dataSet.setDrawFilled(true)

        dataSets.add(dataSet)

        val data = RadarData(dataSets)
        data.setValueTextSize(16f)

        data.setValueFormatter { value, _, _, _ -> value.toString() }

        binding.RadarChart.legend.setEnabled(false);
        binding.RadarChart.getDescription().setEnabled(false);
        binding.RadarChart.setData(data)

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