package com.curso.android.app.practica.proyecto_final.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso

import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.curso.android.app.practica.proyecto_final.R
import org.junit.Rule
import org.junit.Test

@RunWith(AndroidJUnit4::class)
internal class MainActivityTest{

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivity_compararString() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text1)
        ).perform(
            ViewActions.typeText("Texto igual que el otro"),
                closeSoftKeyboard())

        Espresso.onView(
            ViewMatchers.withId(R.id.text2)
        ).perform(
            ViewActions.typeText("Texto igual que el otro"),
                    closeSoftKeyboard())

        Espresso.onView(
            ViewMatchers.withId(R.id.compararButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las cadenas de caracteres son iguales")
            )
        )
    }

    @Test
    fun mainActivity_compararStringDistinto() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text1)
        ).perform(
            ViewActions.typeText("Primer Texto"),
            closeSoftKeyboard())

        Espresso.onView(
            ViewMatchers.withId(R.id.text2)
        ).perform(
            ViewActions.typeText("Soy un texto distinto al otro"),
            closeSoftKeyboard())

        Espresso.onView(
            ViewMatchers.withId(R.id.compararButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las cadenas de caracteres son distintas")
            )
        )
    }
}