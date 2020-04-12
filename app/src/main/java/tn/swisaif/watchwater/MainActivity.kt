package tn.swisaif.watchwater

  import android.content.Intent
  import android.os.Bundle
 import android.view.Menu
 import android.view.MenuItem
  import android.widget.Toolbar
  import androidx.appcompat.app.ActionBar
 import androidx.appcompat.app.AppCompatActivity
 import androidx.fragment.app.Fragment
 import androidx.navigation.findNavController
 import com.google.android.material.bottomnavigation.BottomNavigationView
  import tn.swisaif.watchwater.login_and_register.login.LoginActivity
  import tn.swisaif.watchwater.utils.Utils


class MainActivity : AppCompatActivity() {

    private var toolbar: ActionBar? = null

    private val mOnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                val fragment: Fragment
                when (item.itemId) {
                    R.id.navigation_article -> {
                        toolbar!!.title = "Articles"
                        findNavController(R.id.nav_host_fragment).navigate(R.id.articleFragment)

                        return true
                    }

                    R.id.navigation_notification -> {
                        toolbar!!.title = "Notification"
                        findNavController(R.id.nav_host_fragment).navigate(R.id.notificationFragment)

                        return true
                    }

                    R.id.navigation_alert -> {
                        toolbar!!.title = "Alerts"
                        findNavController(R.id.nav_host_fragment).navigate(R.id.alertFragment)

                        return true
                    }
                    R.id.navigation_quotes -> {
                        toolbar!!.title = "Quotes"
                        findNavController(R.id.nav_host_fragment).navigate(R.id.quotesFragment)

                        return true
                    }
                    R.id.navigation_map -> {
                        toolbar!!.title = "Map"
                        findNavController(R.id.nav_host_fragment).navigate(R.id.mapBoxFragment)
                        return true
                    }

                }
                return false
            }
        }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.logout) {
            startActivity(Intent(this, LoginActivity::class.java))
            return true
        }


        return super.onOptionsItemSelected(item)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar

        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId= R.id.navigation_article
        toolbar!!.title = "WatchWater"
        Utils.infoPopUp(Utils.getToken(applicationContext).toString(),applicationContext)
     }
}