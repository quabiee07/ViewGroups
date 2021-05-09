package com.olgatech.viewgroups

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.olgatech.viewgroups.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    var binding:ActivityDetailBinding? = null
    private var logo =0
    private var name:String? = ""
    private  var detail:String? =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        logo = intent.getIntExtra(Adapter.LOGO_EXTRA,0)
        name = intent.getStringExtra(Adapter.NAME_EXTRA)
        detail = intent.getStringExtra(Adapter.FOOD_EXTRA)
        setUpFoodDets()
    }

    fun setUpFoodDets(){
        binding?.detailTv?.text = detail
        binding?.imageView?.setImageResource(logo)
        title = name
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}