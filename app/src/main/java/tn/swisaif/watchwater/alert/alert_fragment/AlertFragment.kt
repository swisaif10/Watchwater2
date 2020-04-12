package tn.swisaif.watchwater.alert.alert_fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_alert2.*
import kotlinx.android.synthetic.main.fragment_detail_alert.*
import kotlinx.android.synthetic.main.fragment_notification.*

import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.model.NotificationModel
import tn.swisaif.watchwater.notification.NotificationAdapter

/**
 * A simple [Fragment] subclass.
 */
class AlertFragment : Fragment() {
    var dataList: ArrayList<NotificationModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alert2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initUi()
        initListener()
    }

    private fun initListener() {
        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.detailAlert)
        }
    }

    fun initUi() {

        alertRv.layoutManager = LinearLayoutManager(context)
        alertRv.adapter = alertAdapter(dataList)

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
