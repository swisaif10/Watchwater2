package tn.swisaif.watchwater.mapbox


import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import tn.swisaif.watchwater.R

 import com.mapbox.mapboxsdk.Mapbox
 import com.mapbox.mapboxsdk.maps.Style
 import kotlinx.android.synthetic.main.fragment_map_box.*
import java.lang.Exception


/**
 * A simple [Fragment] subclass.
 */
class MapBoxFragment : Fragment() {
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         Mapbox.getInstance(
            activity!!,
            getString(R.string.access_token)
        )
         val view=inflater.inflate(R.layout.fragment_map_box, container, false)


         return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        try {
            progressBar2.visibility=View.VISIBLE
        }catch (e: Exception){}

        mapView!!.onCreate(savedInstanceState)
        mapView!!.getMapAsync { mapboxMap ->
            mapboxMap.setStyle(Style.MAPBOX_STREETS, object : Style.OnStyleLoaded {
               override fun onStyleLoaded(style: Style) {
                   try {
                       progressBar2.visibility=View.INVISIBLE
                   }catch (e: Exception){}

                   // Map is set up and the style has loaded. Now you can add data or make other map adjustments.


                }
            })
        }

    }




    override fun onStart() {
        super.onStart()
        mapView!!.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView!!.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView!!.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView!!.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView!!.onLowMemory()
    }

     override fun onDestroy() {
        super.onDestroy()
        mapView!!.onDestroy()
    }

     override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView!!.onSaveInstanceState(outState)
    }
}
