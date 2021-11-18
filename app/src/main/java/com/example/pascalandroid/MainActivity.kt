package com.example.pascalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pascalandroid.databinding.ActivityMainBinding
import com.example.pascalandroid.screen.BlockVolumeFragment
import com.example.pascalandroid.screen.BlockVolumeShowFragment
import com.example.pascalandroid.screen.CounterFragment
import com.example.pascalandroid.screen.CounterShowFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentBlockVolume: BlockVolumeFragment
    private lateinit var fragmentBlockVolumeShow: BlockVolumeShowFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentBlockVolume = BlockVolumeFragment()
        fragmentBlockVolumeShow = BlockVolumeShowFragment()
        with(binding) {
            supportFragmentManager
                .beginTransaction()
                .add(blockVolumeFragment.id, fragmentBlockVolume)
                .commit()
            supportFragmentManager
                .beginTransaction()
                .add(blockVolumeShowFragment.id, fragmentBlockVolumeShow)
                .commit()
        }
    }

    fun calculate() {
        val result = fragmentBlockVolume.calculateBlockVolume()
        fragmentBlockVolumeShow.getCalculateBlockVolume(result)
    }

}