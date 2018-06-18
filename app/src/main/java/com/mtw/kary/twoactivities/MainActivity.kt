package com.mtw.kary.twoactivities

import android.app.Activity
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {

    //Variable constante
    private val LOG_TAG = MainActivity::class.java.simpleName

    companion object {
        val EXTRA_MESSAGE : String = "com.mtw.kary.twoactivities.extra.MESSAGE"
    }

    val TEXT_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Método asociado al evento OnClick del Botón SEND
    fun launchSecondActivity (view: View) {
        Log.d(LOG_TAG, "Clicked")

        //Recuperar lo que se escribe en la caja de texto
        val message : String = editText_main.text.toString()

        //Declara objeto intent de la clase Intent (Intent Explicito)
        val intent  = Intent (this,SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE,message)

       //startActivity(intent)
        startActivityForResult(intent,TEXT_REQUEST)

    }

    //alt + insert -> Override Methods
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == TEXT_REQUEST && resultCode == Activity.RESULT_OK) {
            val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY) ?: ""
            text_header_reply.visibility = View.VISIBLE
            //text_message_reply.apply { this }
            text_header_reply.visibility = View.VISIBLE
        }

    }
}
