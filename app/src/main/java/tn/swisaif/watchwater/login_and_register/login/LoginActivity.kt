package tn.swisaif.watchwater.login_and_register.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.swisaif.watchwater.MainActivity
import tn.swisaif.watchwater.R
import tn.swisaif.watchwater.model.LoginResponse
import tn.swisaif.watchwater.model.User
import tn.swisaif.watchwater.utils.Utils
import tn.swisaif.watchwater.web_services.RetrofitClient

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progressBar4.visibility= View.GONE

        initListener()

    }

    fun initListener(){

        cirLoginButton.setOnClickListener {
         userLogin()
        }
    }
    private fun userLogin() {
        val email = editTextEmail.text.toString().trim().toLowerCase()
        val password = editTextPassword.text.toString().trim().toLowerCase()

        if (email.isEmpty()) {
            editTextEmail.error = "email requierd"
            editTextEmail.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.error = "mail n'est pas valide"
            editTextEmail.requestFocus()
            return
        }
        if (password.isEmpty()) {
           editTextPassword.error = "password requierd"
           editTextPassword.requestFocus()
            return
        }
        if (password.length < 8) {
           editTextPassword.error = "min 8 caractères"
           editTextPassword.requestFocus()
            return
        }
        progressBar4.visibility = View.VISIBLE
        val user=User(email,password)
        RetrofitClient.INSTANCE.userLogin(user)
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    progressBar4.visibility = View.GONE

                        Utils.erreurPopUp(
                            t.localizedMessage,
                            applicationContext
                        )

                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (Utils.isConnected(this@LoginActivity)) {


                            progressBar4.visibility = View.GONE
                        Utils.saveToken(applicationContext,response.body()?.accessToken.toString())

                        Utils.infoPopUp(response.body()?.accessToken.toString(),applicationContext)

                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))



                    } else {
                        Utils.erreurPopUp(
                           "erreur cnx",
                            applicationContext
                        )
                    }
                }
            })
    }

}
