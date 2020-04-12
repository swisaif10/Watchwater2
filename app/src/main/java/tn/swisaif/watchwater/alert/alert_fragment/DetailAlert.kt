package tn.swisaif.watchwater.alert.alert_fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import jp.wasabeef.blurry.Blurry
import kotlinx.android.synthetic.main.fragment_detail_alert.*

import tn.swisaif.watchwater.R

/**
 * A simple [Fragment] subclass.
 */
class DetailAlert : Fragment() {
    var container: ViewGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view= inflater.inflate(R.layout.fragment_detail_alert, container, false)
        //Blurry.with(context).radius(25).sampling(2).onto(this.container)
        this.container = container


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cancelGtatuitIv.setOnClickListener {
            findNavController().navigate(R.id.alertFragment)

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Blurry.delete(this.container)

    }

}
