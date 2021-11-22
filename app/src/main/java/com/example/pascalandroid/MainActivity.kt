package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.pascalandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Cara yang salah dan kurang tepat ketika init view model
        //counterViewModel = CounterViewModel()

        // 2. ViewModelProviders
        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        binding.apply {
            tvCounter.text = counterViewModel.counter.toString()
            btnIncrement.setOnClickListener {
                counterViewModel.notifyIncrease()
                tvCounter.text = counterViewModel.counter.toString()
            }
        }

        /**
         * ViewModels
         * 1. ViewModel scope -> dia tidak memiliki sebuah data persintance
         * 2. ViewModel -> tidak boleh memiliki referensi langsung terhadap UI (activity, fragment dll)
         * 3. Penguhunung bisa menggunakan Application Context, Livedata (kita pakai ini)
         * 4. Livedata -> observe
         * 5. View -> dia akan mesubscribe apa yang di sediakan oleh si livedata
         */
    }
}