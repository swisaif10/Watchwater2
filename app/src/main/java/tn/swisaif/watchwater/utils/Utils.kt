package tn.swisaif.watchwater.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.ko_popup.view.*
import kotlinx.android.synthetic.main.ok_popup.view.*
import tn.swisaif.watchwater.R


object Utils {

    val PREFERENCES_NAME = "login"
    val NAME_ID = "token"
    val PREFERENCES_IC = "ic"
    val NAME_IC = "ic"
    val isProduction = false
    val PREFERENCES_PREMIUM = "premium"
    val NAME_ID_PREMIUM = "premium"
    fun getBaseUrl(): String {
    //todo R add production link
        if (isProduction) {
            return ""
        } else {
            return "http://maregie.recette-bilog.fr/api/"
        }
    }



    fun getToken(context: Context): String? {
        var sharedPreference = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val token = sharedPreference?.getString(NAME_ID, "")
        return token
    }



    fun isPremium(context: Context) {
        var sharedPreference =
            context.getSharedPreferences(PREFERENCES_PREMIUM, Context.MODE_PRIVATE)
        val editor = sharedPreference?.edit()
        editor?.putInt(NAME_ID_PREMIUM, 1)
        editor?.apply()
    }
    fun saveToken(context: Context,token :String) {
        var sharedPreference =
            context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreference?.edit()
        editor?.putString(NAME_ID, token)
        editor?.apply()
    }

    fun isNotPremium(context: Context) {
        var sharedPreference =
            context.getSharedPreferences(PREFERENCES_PREMIUM, Context.MODE_PRIVATE)
        val editor = sharedPreference?.edit()
        editor?.putInt(NAME_ID_PREMIUM, 0)
        editor?.apply()
    }

    fun getPremiumStatu(context: Context): Int? {
        var sharedPreference =
            context.getSharedPreferences(PREFERENCES_PREMIUM, Context.MODE_PRIVATE)
        val type = sharedPreference?.getInt(NAME_ID_PREMIUM, -1)
        return type
    }



    fun setupUI(activity: Activity, view: View) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener(object : View.OnTouchListener {
                override fun onTouch(v: View, event: MotionEvent): Boolean {
                    hideSoftKeyboard(activity)
                    return false
                }
            })
        }
    }

    fun hideSoftKeyboard(activity: Activity) {
        try {
            val inputMethodManager = activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                activity.currentFocus!!.windowToken, 0
            )
        } catch (e: Exception) {
        }

    }
    fun infoPopUp(msg: String, context: Context) {
        var view = LayoutInflater.from(context).inflate(R.layout.ok_popup, null)
        var toast = Toast(context)
        view.msgOkPopUpTv.text = msg
        toast.view = view
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.TOP, 0, 180)
        toast.show()

    }

    fun erreurPopUp(msg: String, context: Context) {
        var view = LayoutInflater.from(context).inflate(R.layout.ko_popup, null)
        view.msgKoPopUpTv.text = msg
        var toast = Toast(context)
        toast.view = view
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.TOP, 0, 180)
        toast.show()

    }

    fun isConnected(activity: Activity): Boolean {
        val connectivityManager =
            activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    fun shareOption(context : Context,link : String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "eMuse")
        shareIntent.putExtra(Intent.EXTRA_TEXT, link)
        context.startActivity(Intent.createChooser(shareIntent, "Partager à travers"))

    }

    fun isLocationEnabled(context: Context): Boolean {
        var locationMode = 0
        val locationProviders: String

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                locationMode =
                    Settings.Secure.getInt(context.contentResolver, Settings.Secure.LOCATION_MODE)

            } catch (e: Settings.SettingNotFoundException) {
                e.printStackTrace()
                return false
            }

            return locationMode != Settings.Secure.LOCATION_MODE_OFF

        } else {
            locationProviders = Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.LOCATION_PROVIDERS_ALLOWED
            )
            return !TextUtils.isEmpty(locationProviders)
        }


    }




}