package com.app.sportz.retrofit

import android.content.Context

import com.app.sportz.retrofit.Constants.BASE_URL
import com.app.sportz.activities.MainActivity
import com.google.gson.GsonBuilder

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    private var mRetrofitService: Retrofit? = null
    private var mApiClient: ApiClient? = null

    var activity: MainActivity? = null


    fun createApiService() {

        buildApiService()
    }

    fun createAuthorizedApiService(context: Context, token: String) {

        buildApiService()
    }

    fun createApiServiceWithLocale(locale: String) {

        buildApiService()
    }



    private fun buildApiService() {
        mApiClient = null
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        var builder =
            OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(
                Interceptor { chain: Interceptor.Chain ->
                    val request = chain.request()
                    val newReq = request.newBuilder()
                    /*if (mToken != null) {
                        newReq.addHeader(HEADER, " $mToken")
                    }*/

                    val rsp = chain.proceed(newReq.build())
                    if (rsp.code == 401 && activity != null) {
                      //  App.logout(activity!!)
                    }
                    rsp
                }
            )

        builder.connectTimeout(20, TimeUnit.SECONDS)
        builder.writeTimeout(0, TimeUnit.SECONDS)
        builder.readTimeout(10, TimeUnit.MINUTES)
        builder = builder.addInterceptor(interceptor)

        val client = builder.build()
        val gson = GsonBuilder().setLenient().serializeNulls().create()

        mRetrofitService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create(gson)
            )
            .build()
    }

    @JvmStatic
    val apiClient: ApiClient?
        get() {
            if (mRetrofitService != null) {
                if (mApiClient == null) {
                    mApiClient = mRetrofitService!!.create(ApiClient::class.java)
                }
            } else {
                createApiService()
                mApiClient = mRetrofitService!!.create(ApiClient::class.java)
            }
            return mApiClient
        }
}