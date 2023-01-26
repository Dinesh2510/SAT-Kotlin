package com.app.sportz.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.sportz.databinding.ItemPlayerListBinding
import com.app.sportz.retrofit.Response.PlayerDataModelled


class AdapterPlayer(
    conVideoArrayList: List<PlayerDataModelled>,
    context: AppCompatActivity,
    listener: AdapterClickListener
) :
    RecyclerView.Adapter<AdapterPlayer.MyViewHolder>() {
    var conVideoArrayList: List<PlayerDataModelled>
    var context: Context
    var sharedPreferences: SharedPreferences? = null
    var str_userid: String? = null
    private val listener: AdapterClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemPlayerListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: MyViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val obj: PlayerDataModelled = conVideoArrayList[position]

        if (obj.iskeeper != null && obj.iskeeper!!) {
            holder.binding.name.setText(Html.fromHtml("<b>" + "\u2022 " + obj.nameFull + "(wk)" + "<b>"))
        } else if (obj.iscaptain != null && obj.iscaptain!!) {
            holder.binding.name.setText(Html.fromHtml("<b>" + "\u2022 " + obj.nameFull + "(c)" + "<b>"))
        } else if (obj.iscaptain != null && obj.iskeeper != null && obj.iscaptain!! && obj.iskeeper!!) {
            holder.binding.name.setText(Html.fromHtml("<b>" + "\u2022 " + obj.nameFull + "(c  & wk)" + "<b>"))
        } else {
            holder.binding.name.setText("\u2022 " + obj.nameFull)
        }
        holder.binding.lytMain.setOnClickListener(View.OnClickListener { view ->
            listener.onItemClick(
                view,
                position,
                obj
            )
        })
    }

    override fun getItemCount(): Int {
        return conVideoArrayList.size
    }

    class MyViewHolder(rowXmlViewBinding: ItemPlayerListBinding) :
        RecyclerView.ViewHolder(rowXmlViewBinding.getRoot()) {
        val binding: ItemPlayerListBinding

        init {
            binding = rowXmlViewBinding
        }
    }

    init {
        this.conVideoArrayList = conVideoArrayList
        this.context = context
        this.listener = listener
    }
}
