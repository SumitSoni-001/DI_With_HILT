package com.example.hiltproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.hiltproject.databinding.ActivityMainBinding
import com.example.hiltproject.viewModel.FakerViewModel
import com.example.hiltproject.viewModel.FakerViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : FakerViewModelFactory

//    @Inject
    lateinit var fakerViewModel : FakerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fakerViewModel = ViewModelProvider(this , factory)[FakerViewModel::class.java]

        fakerViewModel.productsData.observe(this , Observer {
            findViewById<TextView>(R.id.sampleText).text = it.joinToString {
                products -> products.title +"\n\n"
            }
        })

    }
}