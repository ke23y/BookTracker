package com.example.etta.booktracker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {


    internal val runnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext, ToReadActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    @Override
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        val secondsDelayed = 5000
        Handler().postDelayed(runnable, secondsDelayed.toLong())

        //setUpAnimation()

    }
    /**

    fun setUpAnimation() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.my_anim)

        anim.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                Toast.makeText(this@SplashActivity, getString(R.string.Ani_fini), Toast.LENGTH_LONG).show()
                // start new Activity here
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })

        logo.startAnimation(anim)
    } **/
}
