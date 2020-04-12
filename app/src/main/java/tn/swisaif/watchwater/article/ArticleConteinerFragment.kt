package tn.swisaif.watchwater.article


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import tn.swisaif.watchwater.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_article.*
import tn.swisaif.watchwater.article.artcle_fragment.ArticleFragment
import tn.swisaif.watchwater.article.video.VideoFragment
 

class ArticleConteinerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_article, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       val healthPagerAdapter = PagerAdapter(childFragmentManager)
        healthPagerAdapter.addFragment(ArticleFragment(),"Article")
        healthPagerAdapter.addFragment(VideoFragment(),"Video")
        healthPager!!.adapter = healthPagerAdapter
        healthTabDots!!.setupWithViewPager(healthPager)
        healthPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(healthTabDots))




    }




    }





