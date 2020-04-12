package tn.swisaif.watchwater.alert.event


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_alert2.*
import kotlinx.android.synthetic.main.fragment_event.*
import kotlinx.android.synthetic.main.fragment_event.floatingActionButton

import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.alert.alert_fragment.alertAdapter
import tn.swisaif.watchwater.model.NotificationModel

/**
 * A simple [Fragment] subclass.
 */
class EventFragment : Fragment() {
    var dataList: ArrayList<NotificationModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initUi()
        initListener()
    }

    private fun initListener() {
        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.eventDetails)

        }
    }

    fun initUi() {

        eventRv.layoutManager = LinearLayoutManager(context)
        eventRv.adapter = EventAdapter(dataList)

    }

    fun initData() {
        dataList.add(
            NotificationModel(
                "Vous avez reçu un mail pour activer votre compte",
                "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsu"
            )
        )
        dataList.add(
            NotificationModel(
                "De nouvelles annonces correspondent à vos recherches mémorisées",
                "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsudd ffffffffffffffdfsfgggggggggggggggggggggggggggggg gggggggggggggggggggggggggggggggggggggggggg"
            )
        )
        dataList.add(
            NotificationModel(
                "Vous avez reçu des annonces qui matchent !",
                "lorem ipsum lorem ipsum lorem ipsum lorem ipsum"
            )
        )
        dataList.add(
            NotificationModel(
                "Vous avez reçu un mail pour activer votre compte",
                "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsu"
            )
        )

    }

}
