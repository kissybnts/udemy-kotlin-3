package com.kissybnts.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kissybnts.swoosh.utils.EXTRA_LEAGUE
import com.kissybnts.swoosh.R
import com.kissybnts.swoosh.utils.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBeginnerClicked(view: View) {
        ballerSkillButton.isChecked = false
        this.skill = "beginner"
    }

    fun onBallerClicked(view: View) {
        beginnerSkillButton.isChecked = false
        this.skill = "baller"
    }

    fun onSkillFinishClicked(view: View) {
        if (this.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java).apply {
                putExtra(EXTRA_LEAGUE, league)
                putExtra(EXTRA_SKILL, skill)
            }
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
        }
    }
}
