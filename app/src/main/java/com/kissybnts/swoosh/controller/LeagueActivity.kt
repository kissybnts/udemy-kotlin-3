package com.kissybnts.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kissybnts.swoosh.utils.EXTRA_LEAGUE
import com.kissybnts.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        womensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false
        this.selectedLeague = "mens"
    }

    fun onWomensClicked(view: View) {
        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false
        this.selectedLeague = "womens"
    }

    fun onCoedClicked(view: View) {
        mensLeagueButton.isChecked = false
        womensLeagueButton.isChecked = false
        this.selectedLeague = "co-ed"
    }

    fun leagueNextClicked(view: View) {
        if (this.selectedLeague != "") {
            val skillActivity = Intent(this, SkillActivity::class.java).apply {
                putExtra(EXTRA_LEAGUE, selectedLeague)
            }
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }
}
