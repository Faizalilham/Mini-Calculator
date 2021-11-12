package com.example.minicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.minicalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        hitung()

    }

    private fun setAdapter(){
        val listOperator = arrayOf("+","-","*","/")
        val adapter = ArrayAdapter(this,R.layout.listoperator,listOperator)
        binding.TvOperator.setAdapter(adapter)
    }

    private fun hitung(){
        binding.BtnHitung.setOnClickListener {
            val angka1 = binding.ET1.text.toString()
            val angka2 = binding.ET2.text.toString()
            val operator = binding.TvOperator.text.toString()
            kondisi(operator,angka1.toDouble(),angka2.toDouble())
        }

    }

    private fun kondisi(Operator : String,Angka1 : Double,Angka2 : Double){
        when(Operator){
            "+"-> {
                val result = Angka1 + Angka2
                binding.TvHasil.text = result.toString()
            }
            "-"-> {
                val result = Angka1 - Angka2
                binding.TvHasil.text = result.toString()
            }
            "*"-> {
                val result = Angka1 * Angka2
                binding.TvHasil.text = result.toString()
            }
            "/"-> {
                val result = Angka1 / Angka2
                binding.TvHasil.text = result.toString()
            }
        }
    }
}