package com.azkari.app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var dhikrText: TextView
    private lateinit var countButton: Button
    private lateinit var resetButton: Button
    private lateinit var progress: TextView
    private var count = 0
    private val morning = "اللَّهُمَّ أَنْتَ رَبِّي لَا إِلَٰهَ إِلَّا أَنْتَ، خَلَقْتَنِي وَأَنَا عَبْدُكَ، وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ."
    private val evening = "أَعُوذُ بِكَلِمَاتِ اللَّهِ التَّامَّاتِ مِنْ شَرِّ مَا خَلَقَ."
    private val prayer = "أَسْتَغْفِرُ اللَّهَ، أَسْتَغْفِرُ اللَّهَ، أَسْتَغْفِرُ اللَّهَ."
    private val sleep = "بِاسْمِكَ اللَّهُمَّ أَمُوتُ وَأَحْيَا."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dhikrText = findViewById(R.id.dhikrText)
        countButton = findViewById(R.id.countButton)
        resetButton = findViewById(R.id.resetButton)
        progress = findViewById(R.id.progress)

        findViewById<Button>(R.id.morning).setOnClickListener { showDhikr(morning, "أذكار الصباح") }
        findViewById<Button>(R.id.evening).setOnClickListener { showDhikr(evening, "أذكار المساء") }
        findViewById<Button>(R.id.prayer).setOnClickListener { showDhikr(prayer, "بعد الصلاة") }
        findViewById<Button>(R.id.sleep).setOnClickListener { showDhikr(sleep, "أذكار النوم") }
        findViewById<Button>(R.id.tasbeeh).setOnClickListener { showTasbeeh() }

        countButton.setOnClickListener {
            count++
            dhikrText.text = "📿 $count"
            progress.text = "السبحة: $count"
        }
        resetButton.setOnClickListener {
            count = 0
            dhikrText.text = "📿 0"
            progress.text = "السبحة: 0"
        }
    }

    private fun showDhikr(text: String, title: String) {
        countButton.visibility = View.GONE
        resetButton.visibility = View.GONE
        dhikrText.text = "◈ $title\n\n$text"
        progress.text = "اختر الذكر واقرأه بتدبر"
    }

    private fun showTasbeeh() {
        count = 0
        dhikrText.text = "📿 0"
        progress.text = "السبحة الإلكترونية"
        countButton.visibility = View.VISIBLE
        resetButton.visibility = View.VISIBLE
    }
}
