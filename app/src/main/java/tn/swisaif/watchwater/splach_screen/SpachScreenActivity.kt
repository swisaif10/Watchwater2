package tn.swisaif.watchwater.splach_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import tn.swisaif.watchwater.MainActivity
import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.login_and_register.login.LoginActivity


class SpachScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 1000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spach_screen)
        initUi()

    }

    fun initListener() {

    }

    fun initUi() {
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)

    }

    fun initData() {

    }

}