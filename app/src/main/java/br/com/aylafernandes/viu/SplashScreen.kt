package br.com.aylafernandes.viu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.Animation
import kotlinx.android.synthetic.main.activity_splash_screen.*
import android.content.Intent
import android.os.Handler


class SplashScreen : AppCompatActivity() {


    private val SPLASH_DISPLAY_LENGTH = 3500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        carregar()
    }

    private fun carregar(){
        val anim = AnimationUtils.loadAnimation(this,
                R.anim.animacao_splash)
        anim.reset();



        if (splash != null) {
            splash.clearAnimation()
            splash.startAnimation(anim)
        }

        Handler().postDelayed(Runnable {
            // Após o tempo definido irá executar a próxima tela
            val intent = Intent(this@SplashScreen,  MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
            startActivity(intent)
            this@SplashScreen.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())



     }


}
