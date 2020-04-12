package tn.swisaif.watchwater.article.artcle_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import   androidx.recyclerview.widget.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item_image_content.view.*
import kotlinx.android.synthetic.main.ui_item_row_notification.view.*
import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.model.News
import tn.swisaif.watchwater.utils.Utils


class ArticleAdapter(private var subjectList: MutableList<News>) :

    RecyclerView.Adapter<ArticleAdapter.CustomViewHolder>() {


    // numberOfItems
    override fun getItemCount(): Int {
        return subjectList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.news_item_image_content, parent, false)
        return CustomViewHolder(cellForRow)


    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder?.view?.notificationTitleTv?.text = subjectList[position].title
        holder?.view?.profileNameTV.text = subjectList[position].title
        holder?.view?.articleDateTV.text = subjectList[position].publication_date
        holder?.view?.ImageArticleContentTV.text = subjectList[position].content
        holder?.view?.likesNumberTV.text = subjectList[position].nbr_like
val imageHolder= holder?.view
        if (subjectList[position].img.isNullOrEmpty()){
            imageHolder.newsContentImg.visibility = View.GONE
        } else {
            imageHolder.newsContentImg.visibility = View.VISIBLE
            Picasso.get().load(subjectList[position].img).into(imageHolder.newsContentImg)
        }

        if (subjectList[position].url.isNullOrEmpty()){
            imageHolder.linkTV.visibility = View.GONE
        } else {
            imageHolder.linkTV.visibility = View.VISIBLE
            imageHolder.linkTV.text = subjectList[position].url

        }

        if (subjectList[position].isLiked == "1"){
            imageHolder.likeImg.setImageResource(R.drawable.icons_like_full_red)
        }else {
            imageHolder.likeImg.setImageResource(R.drawable.icons_like)

        }
        imageHolder.shareImg.setOnClickListener {
            Utils.shareOption(it.context,subjectList[position].content)
        }
        imageHolder.likeImg.setOnClickListener {
            if (subjectList[position].isLiked == "1"){
                imageHolder.likeImg.setImageResource(R.drawable.icons_like)
                 subjectList[position].nbr_like = ""+(subjectList[position].nbr_like.toInt()-1)
                imageHolder.likesNumberTV.text = subjectList[position].nbr_like
                subjectList[position].isLiked = "0"


            } else {
                imageHolder.likeImg.setImageResource(R.drawable.icons_like_full_red)
                 subjectList[position].nbr_like = ""+(subjectList[position].nbr_like.toInt()+1)
                imageHolder.likesNumberTV.text = subjectList[position].nbr_like
                subjectList[position].isLiked = "1"
            }

        }

    }

    class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {


        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {


        }
    }


}




