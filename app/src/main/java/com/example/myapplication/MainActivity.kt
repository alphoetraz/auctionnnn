package com.example.myapplication




import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(this@MainActivity, signin::class.java))
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            startActivity(Intent(this@MainActivity, forget_password::class.java))
        }


        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            startActivity(Intent(this@MainActivity, Login ::class.java))
        }






    }
}