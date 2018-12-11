package com.egorshustov.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var mDb: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnLoad = findViewById<Button>(R.id.btnLoad)

        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)

        try {
            mDb = AppDatabase.getInstance(this)

            btnLoad.setOnClickListener {
                textView.text = ""
                val list: List<Record> = mDb?.roomDao()?.getAllRecords()!!
                for (item in list)
                    textView.append(item.note + "\n")
            }

            btnSave.setOnClickListener {
                mDb?.roomDao()?.insertRecord(Record(note = editText.text.toString()))
            }
        }
        catch (e: Exception) {
            Log.d("MyLog", "onCreate exception:", e)
        }
    }
}