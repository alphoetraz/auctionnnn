package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityAdditemBinding
import org.w3c.dom.Text


class Additem : AppCompatActivity() {


    lateinit var binding: ActivityAdditemBinding
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var sendText: Text



    companion object{
        val IMAGE_REQUEST_CODE = 100
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additem)








        button = findViewById(R.id.buton12)
        imageView = findViewById(R.id.imageView3)


        button.setOnClickListener {
            pickImageGallery()

        }


    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            imageView.setImageURI(data?.data)
        }

    }


}


