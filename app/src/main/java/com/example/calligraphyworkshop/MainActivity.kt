package com.example.calligraphyworkshop

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import com.example.calligraphyworkshop.R

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        // 設定字體
        textView.typeface = resources.getFont(R.font.chenyuluoyan_thin_monospaced)

        editText.addTextChangedListener {
            textView.text = it.toString()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textView.textSize = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // 不需要實現此方法
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // 不需要實現此方法
            }
        })
    }
}