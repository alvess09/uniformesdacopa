package alves.ariel.uniformesdacopa

import alves.ariel.uniformesdacopa.databinding.ActivitySplashScreenBinding
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper.*
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivitySplashScreenBinding
@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


            Handler().postDelayed({startActivity(Intent(this, MainActivity::class.java))
                finish() },1500)
    }



}




