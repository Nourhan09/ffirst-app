

package com.example.mytestingapp

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)

        // Set up bottom navigation with NavController

        val bottomNavigationView= findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.firstFragment -> navigateToFragment(FirstFragment())
                R.id.secondFragment -> navigateToFragment(SecondFragment())
                R.id.thirdFragment -> navigateToFragment(ThirdFragment())
            }
            true
        }

        // Button click listener to show data in the selected fragment
        val buttonShowData= findViewById<BottomNavigationView>(R.id.nav_host_fragment)
        buttonShowData.setOnClickListener {
            val editTextName= findViewById<EditText>(R.id.editTextName)
            val name = editTextName.text.toString()
            val editTextAge = findViewById<EditText>(R.id.editTextAge)
            val age = editTextAge.text.toString()
            val dataBundle = Bundle().apply {
                putString("name", name)
                putString("age", age)
            }

            when (navController.currentDestination?.id) {
                R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment -> {
                    navController.navigate(navController.currentDestination!!.id, dataBundle)
                }
            }
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}

