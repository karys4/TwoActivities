package com.mtw.kary.twoactivities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    //Variable constante
    // private val LOG_TAG = MainActivity::class.java.simpleName

    companion object {
        val EXTRA_REPLY : String = "com.mtw.kary.twoactivities.extra.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        text_message.text = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
    }

    fun returnReply (view:View) {
     val replyIntent = Intent()
     val replyMessage = editText_second.text.toString()
     replyIntent.putExtra(EXTRA_REPLY,replyMessage)
     setResult(Activity.RESULT_OK,replyIntent)
        finish()

    }

    //
    override fun onStart() {
        super.onStart()
        Log.w(LOG_TAG, "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w(LOG_TAG, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w(LOG_TAG, "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w(LOG_TAG, "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w(LOG_TAG, "OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w(LOG_TAG, "OnRestart")
    }
}
