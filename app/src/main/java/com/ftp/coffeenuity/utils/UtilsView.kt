package com.ftp.coffeenuity.utils

import android.view.View
import androidx.core.content.ContextCompat
import com.ftp.coffeenuity.R
import com.google.android.material.snackbar.Snackbar

object UtilsView {

    fun View.snackErrorText(text: String) {
        val snackbar = Snackbar.make(this, text, Snackbar.LENGTH_LONG)
        snackbar.view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.colorRose50))
        snackbar.show()
    }

    fun View.snackSuccessText(text: String) {
        val snackbar = Snackbar.make(this, text, Snackbar.LENGTH_LONG)
        snackbar.view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.colorGreen50))
        snackbar.show()
    }


}