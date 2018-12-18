package com.egorshustov.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    private var mDb: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val editId = findViewById<EditText>(R.id.editId)

        val btnInsert = findViewById<Button>(R.id.btnInsert)
        val btnGetAll = findViewById<Button>(R.id.btnGetAll)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)
        val btnDelete = findViewById<Button>(R.id.btnDelete)

        val textOut = findViewById<TextView>(R.id.textOut)

        try {
            mDb = AppDatabase.getInstance(this)

            btnInsert.setOnClickListener {
                mDb?.roomDao()?.insertRecord(Record(note = editText.text.toString(), subnote = ""))
            }

            btnGetOne.setOnClickListener {
                textOut.text = ""
                val note: String? = mDb?.roomDao()?.getOneRecord(parseInt(editId.text.toString()))
                textOut.text = note
            }

            btnGetAll.setOnClickListener {
                textOut.text = ""
                val list: List<Record> = mDb?.roomDao()?.getAllRecords()!!
                for (item in list)
                    textOut.append(item.id.toString() +" "+ item.note + "\n")
            }

            btnUpdate.setOnClickListener {
                val record = Record(parseInt(editId.text.toString()), editText.text.toString(), "")
                mDb?.roomDao()?.updateRecord(record)
            }

            btnDelete.setOnClickListener {
                val record = Record(parseInt(editId.text.toString()), editText.text.toString(), "")
                mDb?.roomDao()?.deleteByUserId(record)
            }

        }
        catch (e: Exception) {
            Log.d("MyLog", "onCreate exception:", e)
        }
    }
}