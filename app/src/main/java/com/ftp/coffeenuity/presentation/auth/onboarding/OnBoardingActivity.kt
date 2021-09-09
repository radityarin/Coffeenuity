package com.ftp.coffeenuity.presentation.auth.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.ftp.coffeenuity.adapter.OnBoardingAdapter
import com.ftp.coffeenuity.data.pref.ProfilePrefs
import com.ftp.coffeenuity.data.staticdata.StaticData
import com.ftp.coffeenuity.databinding.ActivityOnBoardingBinding
import com.ftp.coffeenuity.presentation.MainActivity
import com.ftp.coffeenuity.presentation.auth.login.LoginActivity
import com.ftp.coffeenuity.presentation.auth.register.RegisterActivity
import com.ftp.coffeenuity.utils.helper.SnapOnScrollListener
import com.ftp.coffeenuity.utils.helper.SnapOnScrollListener.Companion.NOTIFY_ON_SCROLL


class OnBoardingActivity : AppCompatActivity() {

    private var _binding: ActivityOnBoardingBinding? = null
    private val binding get() = _binding!!
    private lateinit var onBoardingAdapter: OnBoardingAdapter

    override fun onStart() {
        super.onStart()
        if (ProfilePrefs.idFirebase.isNotEmpty()) {
            startActivity(Intent(this@OnBoardingActivity, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        _binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initOnBoarding()
        initClick()
    }

    private fun initClick() {
        with(binding) {
            btnRegister.setOnClickListener {
                startActivity(
                    Intent(
                        this@OnBoardingActivity,
                        RegisterActivity::class.java
                    )
                )
            }
            btnLogin.setOnClickListener {
                startActivity(
                    Intent(
                        this@OnBoardingActivity,
                        LoginActivity::class.java
                    )
                )
            }
        }
    }

    private fun initOnBoarding() {
        val listOnBoardingModel = StaticData.getOnBoardingData()
        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(binding.rvOnBoarding)
        onBoardingAdapter = OnBoardingAdapter()
        onBoardingAdapter.submitList(listOnBoardingModel)
        with(binding) {
            rvOnBoarding.adapter = onBoardingAdapter
            btnNext.setOnClickListener {
                val layoutManager = rvOnBoarding.layoutManager as LinearLayoutManager
                val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
                if (firstVisiblePosition == listOnBoardingModel.size - 2) {
                    rvOnBoarding.smoothScrollToPosition(firstVisiblePosition + 1)
                    btnLogin.visibility = View.VISIBLE
                    btnRegister.visibility = View.VISIBLE
                    tvWelcome.visibility = View.VISIBLE
                    recyclerViewIndicator.visibility = View.GONE
                    btnNext.visibility = View.GONE
                    btnSkip.visibility = View.GONE
                } else {
                    rvOnBoarding.smoothScrollToPosition(firstVisiblePosition + 1)
                    btnLogin.visibility = View.GONE
                    btnRegister.visibility = View.GONE
                    tvWelcome.visibility = View.GONE
                    recyclerViewIndicator.visibility = View.VISIBLE
                    btnNext.visibility = View.VISIBLE
                    btnSkip.visibility = View.VISIBLE
                }
            }
            recyclerViewIndicator.setRecyclerView(rvOnBoarding)
            btnSkip.setOnClickListener {
                moveToLandingActivity()
            }

            rvOnBoarding.addOnScrollListener(
                SnapOnScrollListener(
                    helper,
                    NOTIFY_ON_SCROLL
                ) { position ->
                    // Do what you want
                    if (position == 2) {
                        btnLogin.visibility = View.VISIBLE
                        btnRegister.visibility = View.VISIBLE
                        tvWelcome.visibility = View.VISIBLE
                        recyclerViewIndicator.visibility = View.GONE
                        btnNext.visibility = View.GONE
                        btnSkip.visibility = View.GONE
                    } else {
                        btnLogin.visibility = View.GONE
                        btnRegister.visibility = View.GONE
                        tvWelcome.visibility = View.GONE
                        recyclerViewIndicator.visibility = View.VISIBLE
                        btnNext.visibility = View.VISIBLE
                        btnSkip.visibility = View.VISIBLE
                    }
                })
        }
    }

    private fun moveToLandingActivity() {
        ProfilePrefs.first_time = false
//        startActivity(Intent(this@OnBoardingActivity, LandingActivity::class.java))
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
//        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}