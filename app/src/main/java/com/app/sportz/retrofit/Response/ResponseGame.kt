package com.app.sportz.retrofit.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseGame {
    @SerializedName("Matchdetail")
    @Expose
    var matchdetail: Matchdetail? = null

    @SerializedName("Nuggets")
    @Expose
    var nuggets: List<String>? = null

    @SerializedName("Innings")
    @Expose
    var innings: List<Inning>? = null

    @SerializedName("Teams")
    @Expose
    val teams: MutableMap<String, AllTeamsData>? =null
    @SerializedName("Notes")
    @Expose
    var notes: Notes? = null

    inner class Series {
        @SerializedName("Id")
        @Expose
        var id: String? = null

        @SerializedName("Name")
        @Expose
        var name: String? = null

        @SerializedName("Status")
        @Expose
        var status: String? = null

        @SerializedName("Tour")
        @Expose
        var tour: String? = null

        @SerializedName("Tour_Name")
        @Expose
        var tourName: String? = null
    }


    inner class AllTeamsData {
        @SerializedName("Name_Full")
        @Expose
        var nameFull: String? = null

        @SerializedName("Name_Short")
        @Expose
        var nameShort: String? = null

        @SerializedName("Players")
        @Expose
        private val players: MutableMap<String, PlayerDataModelled>? = null
        fun getPlayers(): Map<String, PlayerDataModelled>? {
            return players
        }

        fun setPlayers(key: String, playerDataModelled: PlayerDataModelled) {
            players!![key] = playerDataModelled
        }
    }


    inner class ThisOver {
        @SerializedName("T")
        @Expose
        var t: String? = null

        @SerializedName("B")
        @Expose
        var b: String? = null
    }

    inner class Venue {
        @SerializedName("Id")
        @Expose
        var id: String? = null

        @SerializedName("Name")
        @Expose
        var name: String? = null
    }

    inner class Matchdetail {
        @SerializedName("Team_Home")
        @Expose
        var teamHome: String? = null

        @SerializedName("Team_Away")
        @Expose
        var teamAway: String? = null

        @SerializedName("Match")
        @Expose
        var match: Match? = null

        @SerializedName("Series")
        @Expose
        var series: Series? = null

        @SerializedName("Venue")
        @Expose
        var venue: Venue? = null

        @SerializedName("Officials")
        @Expose
        var officials: Officials? = null

        @SerializedName("Weather")
        @Expose
        var weather: String? = null

        @SerializedName("Tosswonby")
        @Expose
        var tosswonby: String? = null

        @SerializedName("Status")
        @Expose
        var status: String? = null

        @SerializedName("Status_Id")
        @Expose
        var statusId: String? = null

        @SerializedName("Player_Match")
        @Expose
        var playerMatch: String? = null

        @SerializedName("Result")
        @Expose
        var result: String? = null

        @SerializedName("Winningteam")
        @Expose
        var winningteam: String? = null

        @SerializedName("Winmargin")
        @Expose
        var winmargin: String? = null

        @SerializedName("Equation")
        @Expose
        var equation: String? = null
    }

    inner class Notes {
        @SerializedName("1")
        @Expose
        private var _1: List<String>? = null

        @SerializedName("2")
        @Expose
        private var _2: List<String>? = null
        fun get1(): List<String>? {
            return _1
        }

        fun set1(_1: List<String>?) {
            this._1 = _1
        }

        fun get2(): List<String>? {
            return _2
        }

        fun set2(_2: List<String>?) {
            this._2 = _2
        }
    }

    inner class Officials {
        @SerializedName("Umpires")
        @Expose
        var umpires: String? = null

        @SerializedName("Referee")
        @Expose
        var referee: String? = null
    }

    inner class PartnershipCurrent {
        @SerializedName("Runs")
        @Expose
        var runs: String? = null

        @SerializedName("Balls")
        @Expose
        var balls: String? = null

        @SerializedName("Batsmen")
        @Expose
        var batsmen: List<Batsman>? = null
    }

    inner class Inning {
        @SerializedName("Number")
        @Expose
        var number: String? = null

        @SerializedName("Battingteam")
        @Expose
        var battingteam: String? = null

        @SerializedName("Total")
        @Expose
        var total: String? = null

        @SerializedName("Wickets")
        @Expose
        var wickets: String? = null

        @SerializedName("Overs")
        @Expose
        var overs: String? = null

        @SerializedName("Runrate")
        @Expose
        var runrate: String? = null

        @SerializedName("Byes")
        @Expose
        var byes: String? = null

        @SerializedName("Legbyes")
        @Expose
        var legbyes: String? = null

        @SerializedName("Wides")
        @Expose
        var wides: String? = null

        @SerializedName("Noballs")
        @Expose
        var noballs: String? = null

        @SerializedName("Penalty")
        @Expose
        var penalty: String? = null

        @SerializedName("AllottedOvers")
        @Expose
        var allottedOvers: String? = null

        @SerializedName("Batsmen")
        @Expose
        var batsmen: List<Batsman>? = null

        @SerializedName("Partnership_Current")
        @Expose
        var partnershipCurrent: PartnershipCurrent? = null

        @SerializedName("Bowlers")
        @Expose
        var bowlers: List<Bowler>? = null

        @SerializedName("FallofWickets")
        @Expose
        var fallofWickets: List<FallofWicket>? = null

        @SerializedName("PowerPlay")
        @Expose
        var powerPlay: PowerPlay? = null

        @SerializedName("Target")
        @Expose
        var target: String? = null
    }

    inner class Batsman {
        @SerializedName("Batsman")
        @Expose
        var batsman: String? = null

        @SerializedName("Runs")
        @Expose
        var runs: String? = null

        @SerializedName("Balls")
        @Expose
        var balls: String? = null

        @SerializedName("Fours")
        @Expose
        var fours: String? = null

        @SerializedName("Sixes")
        @Expose
        var sixes: String? = null

        @SerializedName("Dots")
        @Expose
        var dots: String? = null

        @SerializedName("Strikerate")
        @Expose
        var strikerate: String? = null

        @SerializedName("Dismissal")
        @Expose
        var dismissal: String? = null

        @SerializedName("Howout")
        @Expose
        var howout: String? = null

        @SerializedName("Bowler")
        @Expose
        var bowler: String? = null

        @SerializedName("Fielder")
        @Expose
        var fielder: String? = null

        @SerializedName("Isonstrike")
        @Expose
        var isonstrike: Boolean? = null
    }

    inner class Match {
        @SerializedName("Livecoverage")
        @Expose
        var livecoverage: String? = null

        @SerializedName("Id")
        @Expose
        var id: String? = null

        @SerializedName("Code")
        @Expose
        var code: String? = null

        @SerializedName("League")
        @Expose
        var league: String? = null

        @SerializedName("Number")
        @Expose
        var number: String? = null

        @SerializedName("Type")
        @Expose
        var type: String? = null

        @SerializedName("Date")
        @Expose
        var date: String? = null

        @SerializedName("Time")
        @Expose
        var time: String? = null

        @SerializedName("Offset")
        @Expose
        var offset: String? = null

        @SerializedName("Daynight")
        @Expose
        var daynight: String? = null
    }

    inner class Bowler {
        @SerializedName("Bowler")
        @Expose
        var bowler: String? = null

        @SerializedName("Overs")
        @Expose
        var overs: String? = null

        @SerializedName("Maidens")
        @Expose
        var maidens: String? = null

        @SerializedName("Runs")
        @Expose
        var runs: String? = null

        @SerializedName("Wickets")
        @Expose
        var wickets: String? = null

        @SerializedName("Economyrate")
        @Expose
        var economyrate: String? = null

        @SerializedName("Noballs")
        @Expose
        var noballs: String? = null

        @SerializedName("Wides")
        @Expose
        var wides: String? = null

        @SerializedName("Dots")
        @Expose
        var dots: String? = null

        @SerializedName("Isbowlingtandem")
        @Expose
        var isbowlingtandem: Boolean? = null

        @SerializedName("Isbowlingnow")
        @Expose
        var isbowlingnow: Boolean? = null

        @SerializedName("ThisOver")
        @Expose
        var thisOver: List<ThisOver>? = null
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

    inner class FallofWicket {
        @SerializedName("Batsman")
        @Expose
        var batsman: String? = null

        @SerializedName("Score")
        @Expose
        var score: String? = null

        @SerializedName("Overs")
        @Expose
        var overs: String? = null
    }

    inner class PowerPlay {
        @SerializedName("PP1")
        @Expose
        var pp1: String? = null

        @SerializedName("PP2")
        @Expose
        var pp2: String? = null
    }
}

