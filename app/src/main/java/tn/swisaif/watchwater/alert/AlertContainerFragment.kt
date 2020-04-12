package tn.swisaif.watchwater.alert


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_alert.*

import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.alert.alert_fragment.AlertFragment
import tn.swisaif.watchwater.alert.event.EventFragment
import tn.swisaif.watchwater.article.PagerAdapter

/**
 * A simple [Fragment] subclass.
 */
class AlertContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alert, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val healthPagerAdapter = PagerAdapter(childFragmentManager)
        healthPagerAdapter.addFragment(AlertFragment(),"Alert")
        healthPagerAdapter.addFragment(EventFragment(),"Evenement")
        healthPager!!.adapter = healthPagerAdapter
        healthTabDots!!.setupWithViewPager(healthPager)
        healthPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(healthTabDots))




    }

}
