package com.example.customtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customtoast.R
import android.widget.Toast
import android.view.ViewGroup
import android.widget.TextView
import android.view.Gravity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@MainActivity, "This is simple", Toast.LENGTH_SHORT).show()
            got("Saved Sucessful")
            display("Saved Sucessful")
        })
    }

    fun got(msg1: String?) {
        val op = layoutInflater.inflate(R.layout.hot_layout, findViewById<View>(R.id.mylayout) as ViewGroup)
        val textView = op.findViewById<View>(R.id.textView) as TextView
        textView.text = msg1
        val b = Toast(this@MainActivity)
        b.duration = Toast.LENGTH_SHORT
        b.view = op
        b.setGravity(Gravity.CENTER, 0, 0)
        b.show()
    }

    fun display(msg: String?) {
        val toastv = layoutInflater.inflate(R.layout.custom_toast, findViewById<View>(R.id.custo) as ViewGroup)
        val tvToast = toastv.findViewById<TextView>(R.id.tvToast)
        tvToast.text = msg
        val toast = Toast(this@MainActivity)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = toastv
        toast.setGravity(Gravity.TOP or Gravity.FILL_HORIZONTAL, 0, 0)
        toast.show()
    }
}