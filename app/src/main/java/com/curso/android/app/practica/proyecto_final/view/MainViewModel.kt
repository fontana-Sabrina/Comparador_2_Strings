package com.curso.android.app.practica.proyecto_final.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.proyecto_final.model.Comparador
import kotlinx.coroutines.launch
import java.util.Date

class MainViewModel: ViewModel() {

    val comparador: LiveData<Comparador> get() = _comparador
    private var _comparador = MutableLiveData<Comparador>(Comparador(""))

    fun compararStrings(text1: String, text2: String){
        var respuesta: String  ="Las cadenas de caracteres son "
        if (text1.equals(text2)){
            respuesta +="iguales"
        }else{
            respuesta +="distintas"
        }
        updateComparador(respuesta)
    }

    private fun updateComparador(cadena:String) {
        viewModelScope.launch {
            _comparador.value = Comparador(cadena)
        }
    }

    //Versión sin usar el modelo
/*    fun compararString(text1: String, text2: String): String{
        var respuesta: String  ="Las cadenas de caracteres son "
        if (text1.equals(text2)){
            respuesta +="iguales"
        }else{
            respuesta +="distintas"
        }
        return respuesta
    }*/
}