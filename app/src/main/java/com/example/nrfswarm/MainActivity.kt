package com.example.nrfswarm

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ConnectFragment.OnFragmentInteractionListener, AppCompatActivity() {

    var connect_host = ""
    var connect_topic = ""

   private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_connect -> {
                replaceFragment(ConnectFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_message -> {
                replaceFragment(MessengerFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_status -> {
                replaceFragment(StatusFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_chart -> {
                replaceFragment(ChartFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_about -> {
                replaceFragment(AboutFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(ConnectFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    override fun passConnection(host: String, topic: String) {
        Log.d("DEBUG","Broker IP Address and Topic Passed!")
        connect_host = "tcp://" + host + ":1883"
        Log.d("INFO","Host: $connect_host")
        connect_topic = topic
        Log.d("INFO","Host: $connect_topic")
        //var connectionParams = MQTTConnectionParams("MQTTSample",connect_host,connect_topic,"","")
        //mqttManager = MQTTmanager(connectionParams,applicationContext,this)
        //mqttManager?.connect()
    }
}
