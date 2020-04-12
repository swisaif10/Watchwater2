package tn.swisaif.watchwater.article.video


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_video.*

import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.model.News
import tn.swisaif.watchwater.model.VideoModel

/**
 * A simple [Fragment] subclass.
 */
class VideoFragment : Fragment() {
    var youtubeVideos : ArrayList<YouTubeVideos> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initData()
        initUi()
        initListener()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initData() {
        youtubeVideos.clear()
        youtubeVideos.add(  YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/yRE9LMmxZVk\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add(  YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/o4_rSDZQ7FM\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add(  YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/L_viQ1M9wHA\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add(  YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/UJhkNQ8D1_g\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add(  YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/xSgKKv6ZlbM\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add(  YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/D87hKMo-Umo\" frameborder=\"0\" allowfullscreen></iframe>") );



    }

    private fun initUi() {
        videoRv.layoutManager = LinearLayoutManager(context)
        videoRv.setHasFixedSize(true)
        videoRv.adapter = VideoAdapter(youtubeVideos)
    }

    private fun initListener() {
    }


}
