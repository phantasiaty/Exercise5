package com.example.exercise5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //Module-level variable
    lateinit var viewModel: CountViewModel

    //Create an instance of the Shared Preferences
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize the ViewModel
        viewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        //Initialize the Shared Preferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        imageViewLike.setOnClickListener{
            viewModel.countLike++
            textViewLike.text = viewModel.countLike.toString()
        }

        imageViewDislike.setOnClickListener{
            viewModel.countDislike++
            textViewDislike.text = viewModel.countDislike.toString()
        }
    }

    override fun onStart() {
        Log.d("MainActivity","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity","onResume")
        viewModel.countLike = sharedPreferences.getInt(getString(R.string.like),0)
        viewModel.countDislike = sharedPreferences.getInt(getString(R.string.dislike),0)
        textViewLike.text = viewModel.countLike.toString()
        textViewDislike.text = viewModel.countDislike.toString()
        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity","onPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.like), viewModel.countLike)
            putInt(getString(R.string.dislike),viewModel.countDislike)
            commit()
        }
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity","onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }
}
