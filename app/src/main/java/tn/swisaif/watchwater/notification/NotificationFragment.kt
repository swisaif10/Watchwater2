package tn.swisaif.watchwater.notification


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notification.*

import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.model.NotificationModel

/**
 * A simple [Fragment] subclass.
 */
class NotificationFragment : Fragment() {

    var dataList: ArrayList<NotificationModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initData()
        initUi()
        initListener()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initListener() {
        deleteAllBtn.setOnClickListener {
            dataList.clear()
            notificationRv.adapter?.notifyDataSetChanged()
        }
    }

    fun initUi() {

        notificationRv.layoutManager = LinearLayoutManager(context)
        notificationRv.adapter = NotificationAdapter(dataList)

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
