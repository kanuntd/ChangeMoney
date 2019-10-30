package buu.informatics.s59161081.changmoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


//        override fun onCreate(savedInstanceState: Bundle?) {
//            requestWindowFeature(Window.FEATURE_NO_TITLE)
//
//            super.onCreate(savedInstanceState)
//            try {
//                this.supportActionBar!!.hide()
//            } catch (e: NullPointerException) {
//            }
//
//            window.setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN)
//            setContentView(R.layout.activity_main)
//        }


}
