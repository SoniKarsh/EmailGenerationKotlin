package com.example.karsh.xmlparsingdemoretrofit

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendButton.setOnClickListener {
            sendMail()
        }

    }
    fun sendMail(){
        val recipient = editText_to.text.toString()
        val recipientList = recipient.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val subject = editText_subject.text.toString()
        val message = editText_message.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, recipientList)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT,  message)
        intent.setType("message/rfc822")
        startActivity(Intent.createChooser(intent, "Choose an Email Client. "))
    }

}
