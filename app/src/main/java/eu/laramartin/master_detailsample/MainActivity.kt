package eu.laramartin.master_detailsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
            .setupWithNavController(navController = navHostFragment.navController)
    }
}
