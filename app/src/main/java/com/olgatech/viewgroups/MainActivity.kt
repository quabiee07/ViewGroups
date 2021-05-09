package com.olgatech.viewgroups

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.olgatech.viewgroups.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var adapter: Adapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupList()
    }

    private  fun setupList(){
        adapter = Adapter(this, DummyData.cars)
        binding?.foodListView?.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}