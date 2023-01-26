package com.app.sportz.adapters

import android.view.View


interface AdapterClickListener {
    fun onItemClick(view: View?, pos: Int, obj: Any?)
}