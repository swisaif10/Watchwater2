package tn.swisaif.watchwater.web_services


import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import tn.swisaif.watchwater.model.LoginResponse
import tn.swisaif.watchwater.model.User


interface IcWS {



//    //register
//    @FormUrlEncoded
//    @POST("register")
//    fun createUser(
//        @Field("firstname") firstname: String,
//        @Field("lastname") lastname: String,
//        @Field("email") email: String,
//        @Field("civility") civility: String,
//        @Field("password") password: String,
//        @Field(value = "registrationid") registrationid: String?,
//        @Field(value = "deviceType") deviceType: Int?
//
//
//    ): Call<SignUpResponse>


    //login

    @POST("auth/signin")
    fun userLogin(@Body user: User?):Call<LoginResponse>

}