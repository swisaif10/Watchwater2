package tn.swisaif.watchwater.model

class Alert(
    val titre: String,
    val etat: String,
    val categorie: String,
    val datepub: String,
    val adresse: String,
    val gouvernerat: String = "",
    var delegation: String,
    val code_postal: String,
    val corps: String,
    val image: String?

)

