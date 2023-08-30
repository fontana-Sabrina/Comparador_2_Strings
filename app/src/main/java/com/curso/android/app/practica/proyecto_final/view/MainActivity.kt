package com.curso.android.app.practica.proyecto_final.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.proyecto_final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparador.observe(this){
            binding.resultado.text = "${it.respuesta}"
        }

        binding.compararButton.setOnClickListener {
            mainViewModel.compararStrings(binding.text1.getText().toString() ,binding.text2.getText().toString())
        }

        //Versión sin usar el modelo
/*        binding.button.setOnClickListener {
            binding.textView.setText(mainViewModel.compararString(binding.text1.getText().toString() ,binding.text2.getText().toString()));
        }*/
    }
}