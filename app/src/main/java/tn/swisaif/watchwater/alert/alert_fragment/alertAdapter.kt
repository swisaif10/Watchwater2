package tn.swisaif.watchwater.alert.alert_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import   androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.ui_item_event.view.*
import kotlinx.android.synthetic.main.ui_item_row_notification.view.*
import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.model.NotificationModel


class alertAdapter(private var subjectList: MutableList<NotificationModel>) :

    RecyclerView.Adapter<alertAdapter.CustomViewHolder>() {


    // numberOfItems
    override fun getItemCount(): Int {
        return subjectList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.ui_item_event, parent, false)
        return CustomViewHolder(cellForRow)


    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder?.view?.titleTv?.text = subjectList[position].title
        holder?.view?.bodyTv?.text = subjectList[position].description


    }

    class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        //todo R le role de l'attribue subject???
        lateinit var subject: NotificationModel

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {


        }
    }


}




