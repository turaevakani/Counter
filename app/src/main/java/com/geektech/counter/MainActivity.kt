package com.geektech.counter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.geektech.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    var count = 0
    private val presenter = Injector.getPresenter()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.fillCounterView(this)
        initClicker()

    }

    private fun initClicker() {
        with(binding){
            btnIncrement.setOnClickListener {
                presenter.increment()
            }

            btnDecrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showNewCount(count: Int){
        binding.tvResult.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(applicationContext, "Congratulations!", Toast.LENGTH_SHORT).show()
    }

    override fun setGreenColor() {
        binding.tvResult.setTextColor(resources.getColor(R.color.green))

    }

    override fun setGreyColor() {
        binding.tvResult.setTextColor(resources.getColor(R.color.grey))

    }


}