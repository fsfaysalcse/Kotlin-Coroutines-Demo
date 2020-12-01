package com.faysal.testapp

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivityTTT"
    }

    lateinit var maintext: TextView

    lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maintext = findViewById(R.id.maintext)

        apiInterface = NetworkBuilder.getInstance().create(ApiInterface::class.java)






        GlobalScope.launch(Dispatchers.IO) {
            async {
                val response = apiInterface.getPosts()
                if (response.isSuccessful) {
                    val resbody = response.body()

                    withContext(Dispatchers.Main) {
                        Log.d(TAG, "POST "+resbody?.get(0)?.title.toString())
                    }

                } else {

                }
            }

            async {
                val response = apiInterface.getTodos()
                if (response.isSuccessful) {
                    val resbody = response.body()

                    withContext(Dispatchers.Main) {
                        Log.d(TAG, "TODO "+resbody?.get(0)?.title.toString())
                    }

                } else {

                }
            }



        }

    }



}