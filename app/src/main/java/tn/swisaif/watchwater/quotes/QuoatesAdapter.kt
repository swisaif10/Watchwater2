package tn.swisaif.watchwater.quotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import   androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.ui_item_quotes.view.*
import kotlinx.android.synthetic.main.ui_item_row_notification.view.*
import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.model.NotificationModel
import tn.swisaif.watchwater.model.QuotesModel


class QuoatesAdapter(private var subjectList: MutableList<QuotesModel>) :

    RecyclerView.Adapter<QuoatesAdapter.CustomViewHolder>() {


    // numberOfItems
    override fun getItemCount(): Int {
        return subjectList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.ui_item_quotes, parent, false)
        return CustomViewHolder(cellForRow)


    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder?.view?.quotesTv?.text = subjectList[position].title


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




