package eu.laramartin.master_detailsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.main_container)

        findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
            .setupWithNavController(navController = navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar!!.title = destination.label
            when (destination.id) {
                R.id.fragment_account,
                R.id.fragment_settings,
                R.id.fragment_notifications -> {
                    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                }
                else -> supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                navController.popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
