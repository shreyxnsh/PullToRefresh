package com.example.pulltorefreshassignment

import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import android.widget.TextView
import android.widget.ArrayAdapter
import android.os.Bundle
import android.widget.ListView
import com.example.pulltorefreshassignment.R
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // I used listView because it could do the task much more easily than recyclerView where I had to create separate adapter class.

        //Initializing variables
        val swipeRefreshLayout : SwipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        val listView : ListView = findViewById(R.id.card_list)
        val arrayList : ArrayList<Int> = ArrayList()

        //Add values in array List
        arrayList.add(1)

        //Initialize array adapter
        val adapter : ArrayAdapter<Int> = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, arrayList)

        //Set adapter
        listView.adapter = adapter
        swipeRefreshLayout.setOnRefreshListener {
            //adding the cards
            arrayList.add(arrayList.size + 1)
            //notify adapter
            adapter.notifyDataSetChanged()
            //dismiss refreshing
            swipeRefreshLayout.isRefreshing = false

        }
    }
}