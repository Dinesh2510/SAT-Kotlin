package com.app.sportz.Interface


import com.app.sportz.retrofit.ApiService
import com.app.sportz.retrofit.Response.ResponseGame
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenterImpl(var view: Presenter.MainPresenter.View) : Presenter.MainPresenter {

    private var backPressedTime: Long = 0

    override fun gameData() {
        view.showLoading()
        val registerUser = ApiService.apiClient!!.getGameData()
        registerUser.enqueue(object : Callback<ResponseGame> {
            override fun onResponse(
                call: Call<ResponseGame>,
                response: Response<ResponseGame>
            ) {
                val resp = response.body()
                if (resp != null) {
                    view.hideLoading()
                    view.onGetResult(resp)

                }else{
                    view.hideLoading()
                    view.onErrorLoading("Data Not Available")
                }
            }

            override fun onFailure(call: Call<ResponseGame>, t: Throwable) {
                view.hideLoading()
                view.onErrorLoading("something wrong")
            }
        })
    }

    override fun created() {
        view.init()
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            view.finishApp()
        } else {
            view.showAppExitInfo()
        }
        backPressedTime = System.currentTimeMillis()
    }

}