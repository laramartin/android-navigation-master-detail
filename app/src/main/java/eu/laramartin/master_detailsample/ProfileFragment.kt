package eu.laramartin.master_detailsample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.findViewById<TextView>(R.id.account_textview).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.fragment_account)
        )
        view.findViewById<TextView>(R.id.notifications_textview).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.fragment_notifications)
        )
        view.findViewById<TextView>(R.id.settings_textview).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.fragment_settings)
        )

        return view
    }
}
