package com.app.sportz.activities

import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager

import com.app.sportz.R
import com.app.sportz.Utlis.CommonFunctions
import com.app.sportz.adapters.AdapterClickListener
import com.app.sportz.adapters.AdapterPlayer
import com.app.sportz.databinding.ActivityDetailsPageBinding
import com.app.sportz.retrofit.Response.PlayerDataModelled
import com.app.sportz.retrofit.Response.ResponseGame
import com.google.gson.Gson

class DetailsPage : AppCompatActivity() {
    lateinit var binding: ActivityDetailsPageBinding
    var responseGame: ResponseGame? = null
    var selected_filter_name = ""
    var str_team_one = ""
    var str_team_two: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
    }

    private fun initData() {
        val gson = Gson()
        responseGame = gson.fromJson(intent.getStringExtra("myjson"), ResponseGame::class.java)
        binding.lytTool.imgbck.setOnClickListener { view -> finish() }
        binding.lytTool.toolbrLbl.setText(
            responseGame?.teams?.teamOne?.nameShort + " vs " + responseGame?.teams?.teamTwo?.nameShort
        )
        str_team_one = responseGame?.teams?.teamOne?.nameShort.toString()
        str_team_two = responseGame?.teams?.teamTwo?.nameShort.toString()

        //FilterView
        AddFilterOnView(str_team_one, str_team_two!!)

        //set Data to arraylist for team one
        val playerList_teams_one: ArrayList<PlayerDataModelled> =
            ArrayList<PlayerDataModelled>(responseGame!!.teams?.teamOne?.getPlayers()?.values)
        //set Data to arraylist for team Two
        val playerList_teams_two: ArrayList<PlayerDataModelled> =
            ArrayList<PlayerDataModelled>(
                responseGame!!.teams?.teamTwo?.getPlayers()?.values
            )

        //Teams One Data Set
        binding.teamName.text = responseGame!!.teams?.teamOne?.nameFull
        binding.rvTeamOne.layoutManager =
            LinearLayoutManager(this@DetailsPage, LinearLayoutManager.VERTICAL, false)
        binding.rvTeamOne.adapter =
            AdapterPlayer(playerList_teams_one, this@DetailsPage, object : AdapterClickListener {
                override fun onItemClick(view: View?, pos: Int, obj: Any?) {
                    val model: PlayerDataModelled = obj as PlayerDataModelled
                    showDialogProject(model)
                }
            })

        //Teams Two Data Set
        binding.teamNameTwo.text = responseGame!!.teams?.teamTwo?.nameFull
        binding.rvTeamTwo.layoutManager =
            LinearLayoutManager(this@DetailsPage, LinearLayoutManager.VERTICAL, false)
        binding.rvTeamTwo.adapter =
            AdapterPlayer(playerList_teams_two, this@DetailsPage, object : AdapterClickListener {
                override fun onItemClick(view: View?, pos: Int, obj: Any?) {
                    val model: PlayerDataModelled = obj as PlayerDataModelled
                    showDialogProject(model)
                }
            })
    }

    var dialog_details: Dialog? = null

    private fun showDialogProject(modelled: PlayerDataModelled) {
        dialog_details = Dialog(this)
        dialog_details!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog_details!!.setContentView(R.layout.dialog_info)
        dialog_details!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog_details!!.setCancelable(true)
        (dialog_details!!.findViewById<View>(R.id.title) as TextView).text = modelled?.nameFull
        (dialog_details!!.findViewById<View>(R.id.bating_style) as TextView).text =
            "Batting Style: " + modelled?.batting?.style
        (dialog_details!!.findViewById<View>(R.id.ball_style) as TextView).text =
            "Bowling Style: " + modelled?.bowling?.style
        dialog_details!!.findViewById<View>(R.id.bt_negative)
            .setOnClickListener { v: View? -> dialog_details!!.dismiss() }
        dialog_details!!.show()
    }

    private fun AddFilterOnView(team_one: String, team_two: String) {
        binding.lnrrattingFilter.removeAllViews()
        val rattingList = ArrayList<String>()
        rattingList.add("All")
        rattingList.add(team_one)
        rattingList.add(team_two)
        for (i in rattingList.indices) {
            AddDataonView(rattingList[i], i)
        }
    }

    private fun AddDataonView(name: String, position: Int) {
        val view: View = CommonFunctions.CreateDynamicViews(
            R.layout.item_filter,
            binding.lnrrattingFilter,
            this@DetailsPage
        )
        val tvrating = view.findViewById<TextView>(R.id.tvrating)
        tvrating.text = "" + name
        tvrating.tag = "" + name
        if (position == 0) {
            onRatingClick(name)
        }
        view.setOnClickListener { onRatingClick(name) }
    }

    private fun onRatingClick(name_filter: String) {
        for (i in 0 until binding.lnrrattingFilter.childCount) {
            val view = binding.lnrrattingFilter.getChildAt(i)
            val tvrating = view.findViewById<TextView>(R.id.tvrating)
            val lnrBackground = view.findViewById<View>(R.id.lnrBackground)
            if (tvrating.tag.toString().trim { it <= ' ' } == name_filter) {
                selected_filter_name = name_filter
                if (CommonFunctions.checkStringisValid(selected_filter_name)) {
                    if (selected_filter_name == "All") {
                        binding.cardTeamOne.visibility = View.VISIBLE
                        binding.cardTeamTwo.visibility = View.VISIBLE
                    } else if (selected_filter_name == str_team_one) {
                        binding.cardTeamOne.visibility = View.VISIBLE
                        binding.cardTeamTwo.visibility = View.GONE
                    } else {
                        binding.cardTeamOne.visibility = View.GONE
                        binding.cardTeamTwo.visibility = View.VISIBLE
                    }
                }
                tvrating.setTextColor(CommonFunctions.getColor(this, R.color.white))
                lnrBackground.backgroundTintList =
                    ColorStateList.valueOf(Color.parseColor("#FF3700B3"))
            } else {
                tvrating.setTextColor(CommonFunctions.getColor(this, R.color.grey_60))
                lnrBackground.background =
                    ContextCompat.getDrawable(this, R.drawable.d_round_corner_item)
                lnrBackground.backgroundTintList = null
            }
        }
    }
}