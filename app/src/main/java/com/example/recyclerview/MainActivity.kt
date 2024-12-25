package com.example.recyclerview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var wordList: MutableList<String>
    private lateinit var adapter: WordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val addButton: Button = findViewById(R.id.addButton)

        // Data
        wordList = mutableListOf()
        for (i in 0 until 20) {
            wordList.add("Word $i")
        }

        // Call Adapter
        adapter = WordListAdapter(wordList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Click Add List
        addButton.setOnClickListener {
            val newWord = "Word ${wordList.size}"
            wordList.add(newWord)
            adapter.notifyItemInserted(wordList.size - 1)
            recyclerView.scrollToPosition(wordList.size - 1)
        }
    }
}
