package com.app.sportz.retrofit.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlayerDataModelled {
    @SerializedName("Position")
    @Expose
    var position: String? = null

    @SerializedName("Name_Full")
    @Expose
    var nameFull: String? = null

    @SerializedName("Iskeeper")
    @Expose
    var iskeeper: Boolean? = null

    @SerializedName("Iscaptain")
    @Expose
    var iscaptain: Boolean? = null

    @SerializedName("Batting")
    @Expose
    var batting: Batting? = null

    @SerializedName("Bowling")
    @Expose
    var bowling: Bowling? = null

    inner class Batting {
        @SerializedName("Style")
        @Expose
        var style: String? = null

        @SerializedName("Average")
        @Expose
        var average: String? = null

        @SerializedName("Strikerate")
        @Expose
        var strikerate: String? = null

        @SerializedName("Runs")
        @Expose
        var runs: String? = null
    }

    inner class Bowling {
        @SerializedName("Style")
        @Expose
        var style: String? = null

        @SerializedName("Average")
        @Expose
        var average: String? = null

        @SerializedName("Economyrate")
        @Expose
        var economyrate: String? = null

        @SerializedName("Wickets")
        @Expose
        var wickets: String? = null
    }
}
