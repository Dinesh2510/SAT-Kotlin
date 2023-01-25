package com.app.sportz.Utlis

import android.view.ViewGroup
import android.view.LayoutInflater
import com.app.sportz.Utlis.CommonFunctions
import android.view.ViewGroup.MarginLayoutParams
import android.net.ConnectivityManager
import kotlin.jvm.JvmOverloads
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View

object CommonFunctions {
    fun CreateDynamicViews(layout: Int, addingview: ViewGroup, context: Context?): View {
        val view = LayoutInflater.from(context).inflate(layout, null)
        setMargins(view, 15, 0, 15, 0)
        addingview.addView(view)
        return view
    }

    fun getColor(context: Context, icons: Int): Int {
        return context.resources.getColor(icons)
    }

    fun setMargins(view: View, left: Int, top: Int, right: Int, bottom: Int) {
        if (view.layoutParams is MarginLayoutParams) {
            val p = view.layoutParams as MarginLayoutParams
            p.setMargins(left, top, right, bottom)
            view.requestLayout()

//            Funtions.LOGE("MainAcitvity","Left : "+left);
        }
    }

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }

    @JvmOverloads
    fun showNoInternetDialog(context: Activity, close: Boolean = false) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Please check your internet connection!")
            .setPositiveButton("OK") { dialog, id ->
                if (close) {
                    context.finish()
                }
            }
        val alert = builder.create()
        alert.show()
    }

    fun isStringValid(text: String?): Boolean {
        return text != null && text != "" && text != "null"
    }

    fun checkStringisValid(text: String?): Boolean {
        return text != null && text != "" && text != "null" && text != "0" && text != "0.0"
    }
}