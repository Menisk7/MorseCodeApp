package com.duck.morseCodeApp.ui.mainscreen




import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.duck.morseCodeApp.R
import com.duck.morseCodeApp.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


        // TODO: the floating btn with envelope on it might be usefull now it's disabled
        binding.fab.setOnClickListener {

        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        setOnMenuItemClickListener(item)
        return when (item.itemId) {
            R.id.action_about0 -> {
                // Handle click on "Action Settings" menu item
                true
            }
            R.id.action_about1 -> {
                // Handle click on "Action About" menu item
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }


    private fun setOnMenuItemClickListener(item: MenuItem) {
        //MenuItem listener
        // if you click on item in the list then clickListener is triggered and it shows title of that item in toast
//        val data= EncryptedSharedPreferences().getSharedPreferences(applicationContext)
//        data.edit().putString("pop",item.title.toString()).apply()
        //println(data.getString("pop","12334"))

        if (item.itemId == android.R.id.home) {
            // Handle back button click
        } else {
            Toast.makeText(binding.root.context, item.title, Toast.LENGTH_LONG).show()
        }
    }





}



