package eu.laramartin.master_detailsample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lateinit var view: View

        val isTablet = context!!.resources.getBoolean(R.bool.isTablet)

        when {
            isTablet -> {
                view = inflater.inflate(R.layout.fragment_profile_land, container, false)
                displayMasterDetailLayout(view)
            }
            else -> {
                view = inflater.inflate(R.layout.fragment_profile, container, false)
                displaySingleLayout(view)
            }
        }

        return view
    }

    private fun displaySingleLayout(view: View) {
        view.findViewById<TextView>(R.id.account_textview).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_profile_fragment_to_fragment_account)
        )
        view.findViewById<TextView>(R.id.notifications_textview).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_profile_fragment_to_fragment_notifications)
        )
        view.findViewById<TextView>(R.id.settings_textview).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_profile_fragment_to_fragment_settings)
        )
    }

    private fun displayMasterDetailLayout(view: View) {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.profile_nav_container) as NavHostFragment

        view.findViewById<TextView>(R.id.account_textview).setOnClickListener {
            navHostFragment.navController.navigate(R.id.fragment_account)
        }

        view.findViewById<TextView>(R.id.notifications_textview).setOnClickListener {
            navHostFragment.navController.navigate(R.id.fragment_notifications)
        }

        view.findViewById<TextView>(R.id.settings_textview).setOnClickListener {
            navHostFragment.navController.navigate(R.id.fragment_settings)
        }
    }
}
