package tn.swisaif.watchwater.quotes


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_quotes.*

import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.model.QuotesModel

/**
 * A simple [Fragment] subclass.
 */
class QuotesFragment : Fragment() {
    var dataList: ArrayList<QuotesModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initData()
        initUi()
        initListener()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initListener() {

    }

    fun initUi() {

        quotesRv.layoutManager = LinearLayoutManager(context)
        quotesRv.adapter = QuoatesAdapter(dataList)

    }

    fun initData() {
        dataList.add(
            QuotesModel(
                "“If there is magic on this planet, it is contained in water.”"
             )
        )

        dataList.add(
            QuotesModel(
                "“Water is the driving force of all nature.”"
            )
        )
        dataList.add(
            QuotesModel(
                "Nothing is softer or more flexible than water, yet nothing can resist it."
            )
        )
        dataList.add(
            QuotesModel(
                "“We forget that the water cycle and the life cycle are one.”"
            )
        )
        dataList.add(
            QuotesModel(
                "“Thousands have lived without love, not one without water.”"
            )
        )

        dataList.add(
            QuotesModel(
                "“The cure for anything is salt water: sweat, tears or the sea.” "
            )
        )

        dataList.add(
            QuotesModel(
                "“In one drop of water are found all the secrets of all the oceans.” "
            )
        )

        dataList.add(
            QuotesModel(
                "“A river seems a magic thing. A magic, moving, living part of the very earth itself.” "
            )
        )

        dataList.add(
            QuotesModel(
                "“We forget that the water cycle and the life cycle are one.”"
            )
        )
    }

}
