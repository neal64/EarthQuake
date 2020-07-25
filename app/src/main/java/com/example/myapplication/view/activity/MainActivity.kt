package com.example.myapplication.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.R


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val navigation = NavHostFragment.create(R.navigation.nav_map)
        supportFragmentManager.beginTransaction().add(R.id.design_navigation_view, navigation).setPrimaryNavigationFragment(navigation).commit()

    }

}