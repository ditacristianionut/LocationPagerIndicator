package com.dci.dev.locationindicator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        pager.adapter = MainPagerAdapter()
        pager.offscreenPageLimit = 3
        dots.setup(pager, 0)

        pager.onPageSelected {
            val colorRes = when (it) {
                0 -> R.color.blue
                1 -> R.color.red
                2 -> R.color.white
                else -> R.color.green
            }
            val color = ContextCompat.getColor(this, colorRes)
            frame.setBackgroundColor(color)
            dots.setDotTintRes(if (color.isColorLight()) R.color.black else R.color.white)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
