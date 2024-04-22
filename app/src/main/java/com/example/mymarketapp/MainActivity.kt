package com.example.mymarketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        popupMenuMain()
    }

    private fun popupMenuMain(){
        val popupMenu = PopupMenu(applicationContext, findViewById<ImageView>(R.id.profile_picture))
        popupMenu.inflate(R.menu.popup_menu_main)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId){
                R.id.nav_edit_profile -> {
                    Toast.makeText(applicationContext, "Berhasil Tekan Edit Profile", Toast.LENGTH_LONG).show()
                    val moveIntent = Intent(this@MainActivity, ProfilePage::class.java)
                    startActivity(moveIntent)
                    true
                }
                R.id.nav_wishlist -> {
                    Toast.makeText(applicationContext, "Berhasil Tekan Wishlist", Toast.LENGTH_LONG).show()


                    //ONLY FOR TESTING MOVING ACTIVITY (SUCCESSFUL)
                    val moveIntent = Intent(this@MainActivity, LoginPage::class.java)
                    startActivity(moveIntent)
                    //ONLY FOR TESTING MOVING ACTIVITY (SUCCESSFUL)


                    true
                }
                R.id.nav_tracking -> {
                    Toast.makeText(applicationContext, "Berhasil Tekan Edit Tracking", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.nav_customer_service -> {
                    Toast.makeText(applicationContext, "Berhasil Tekan CS", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.nav_history -> {
                    Toast.makeText(applicationContext, "Berhasil Tekan History", Toast.LENGTH_LONG).show()
                    true
                }
                else -> true
            }
        }

        findViewById<ImageView>(R.id.profile_picture).setOnClickListener{

            try {
                val popup = PopupMenu::class.java.getDeclaredField("mPopup")
                popup.isAccessible = true;
                val menu = popup.get(popupMenu)
                menu.javaClass.getDeclaredMethod("setForeceShowIcon", Boolean::class.java)
                    .invoke(menu, true)
            } catch(e: Exception){
                e.printStackTrace()
            } finally {
                popupMenu.show()
            }

            true
        }


    }






    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}