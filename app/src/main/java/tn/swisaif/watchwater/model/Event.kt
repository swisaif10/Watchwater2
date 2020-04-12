package tn.swisaif.watchwater.model

class Event(
    val titre: String,
    val etat: String,
    val parmalien: String,
    val datedebut: String,
    val datefin: String,
    val emplacement: String,
    val extrait: String = "",
    var date: String,
     val description: String,
    val image: String?

)

