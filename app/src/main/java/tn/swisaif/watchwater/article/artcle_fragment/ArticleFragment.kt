package tn.swisaif.watchwater.article.artcle_fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_article2.*

import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.model.News
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class ArticleFragment : Fragment() {
    var dataList: ArrayList<News> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            progressBar.visibility=View.VISIBLE
        }catch (e:Exception){}
        initData()
        initUi()
        initListener()
        try {
            progressBar.visibility=View.GONE
        }catch (e:Exception){}
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initData() {

        dataList.clear()
        dataList.add(
            News(
                "coupure d'eau a bej acoupure d'eau a bejacoupure d'eau a bejacoupure d'eau a bejacoupure d'eau a bejacoupure d'eau a beja",
                "28/01/2020","","","","https://radiomedtunisie.com/wp-content/uploads/2018/10/t%C3%A9l%C3%A9chargement.png","true","false","","","5"
            ,"2","","28/01/2020","Problème d'eau à beja","")
            )

        dataList.add(
            News(
                "coupure d'eau a kasserine coupure d'eau a bejacoupure d'eau a bejacoupure d'eau a bejacoupure d'eau a bejacoupure d'eau a bejacoupure d'eau a beja",
                "28/01/2020","","","","https://www.terresacree.org/actualites/fichiers/images/2013-05/1369645495-R3k.jpg","true","false","","","15"
                ,"8","","28/01/2020","Problème d'eau à kasserine","")
        )

        dataList.add(
            News(
                "coupure d'eau a gabes coupure d'eau a beja",
                "28/01/2020","","","","http://www.journaldelenvironnement.net/mediatheque/1/0/4/000002401_5.jpg","true","false","","","6"
                ,"2","","28/01/2020","Problème d'eau à gabes","")
        )

        dataList.add(
            News(
                "coupure d'eau a feriana",
                "28/01/2020","","","","https://www.consoglobe.com/wp-content/uploads/2014/03/LifeStraw.jpg","true","false","","","7"
                ,"2","","28/01/2020","Problème d'eau à feriana","")
        )

     }

    private fun initUi() {
        articleRv.layoutManager = LinearLayoutManager(context)
        articleRv.adapter = ArticleAdapter(dataList)
     }

    private fun initListener() {
     }


}
