package tn.swisaif.watchwater.model

class News(
    val content: String,
    val creation_date: String,
    val edited: String,
    val enabled: String,
    val id: String,
    val img: String = "",
    var isLiked: String,
    val isShared: String,
    val isViewed: String,
    val last_update: String?,
    var nbr_like: String,
    val nbr_share: String,
    val nbr_view: String,
    val publication_date: String,
    val title: String,
    val url: String
)

