package com.curso.android.app.practica.proyecto_final

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.proyecto_final.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.comparador.value?.respuesta
        assertEquals("", value)
    }

    @Test
    fun mainViewModel_TestCompararStringsIgual() = runTest {
        launch {
            viewModel.compararStrings("texto","texto")
        }
        advanceUntilIdle()
        val value = viewModel.comparador.value?.respuesta
        assertEquals("Las cadenas de caracteres son iguales", value)
    }

    @Test
    fun mainViewModel_TestCompararStringsDistinto() = runTest {
        launch {
            viewModel.compararStrings("texto 1","texto 2")
        }
        advanceUntilIdle()
        val value = viewModel.comparador.value?.respuesta
        assertEquals("Las cadenas de caracteres son distintas", value)
    }

}