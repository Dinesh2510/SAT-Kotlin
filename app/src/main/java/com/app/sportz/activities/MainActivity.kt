package com.app.sportz.activities

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.sportz.Interface.MainPresenterImpl
import com.app.sportz.Interface.Presenter
import com.app.sportz.Utlis.CommonFunctions
import com.app.sportz.databinding.ActivityMainBinding
import com.app.sportz.retrofit.Response.ResponseGame
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), Presenter.MainPresenter.View {
    lateinit var binding: ActivityMainBinding
    lateinit var mainPresenter: Presenter.MainPresenter
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainPresenter = MainPresenterImpl(this)
        mainPresenter.created()

    }

    override fun init() {
        progressDialog = ProgressDialog(this@MainActivity)
        progressDialog?.setCancelable(false)
        progressDialog?.setMessage("Loading..")
        binding.lytTool.imgbck.visibility = View.GONE
        binding.lytTool.toolbrLbl.text = " Home"
        if (CommonFunctions.isNetworkConnected(this@MainActivity)) {
            mainPresenter.gameData()
        } else {
            CommonFunctions.showNoInternetDialog(this@MainActivity)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onGetResult(responseGame: ResponseGame?) {

        binding.dateTime.text =
            responseGame?.matchdetail?.match?.date + " at " + responseGame?.matchdetail?.match?.time

        binding.location.text = responseGame?.matchdetail?.venue?.name
        binding.teamName.text = responseGame?.teams?.teamOne?.nameFull + " vs " + responseGame?.teams?.teamTwo?.nameFull
        binding.seeMore.setOnClickListener { view ->
            val gson = Gson()
            val intent = Intent(this@MainActivity, DetailsPage::class.java)
            val myJson = gson.toJson(responseGame)
            intent.putExtra("myjson", myJson)
            startActivity(intent)
        }
    }

    override fun onErrorLoading(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }

    override fun hideLoading() {
        progressDialog!!.dismiss()
    }

    override fun showLoading() {
        progressDialog!!.show()
    }

    override fun finishApp() {
        finish()
    }

    override fun showAppExitInfo() {
        Toast.makeText(this, "Tap Again to exit App", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        mainPresenter.onBackPressed()
    }

}