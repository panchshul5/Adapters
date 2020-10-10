package com.pushpendra.practice.android.adapterviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val list = generateDummyList(500)
    private val adapter = ListitemAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val list = generateDummyList(500)
        item_recycler_view.adapter = adapter
        item_recycler_view.layoutManager = LinearLayoutManager(this)
        item_recycler_view.setHasFixedSize(true)
    }


    private fun generateDummyList(size : Int) : ArrayList<ItemViewClass> {

        val list = arrayListOf<ItemViewClass>()

        for (i in 0 until size) {

            val drawable = when (i%3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_access_time
                else -> R.drawable.ic_adb
            }

            val item = ItemViewClass(drawable,"item #$i","line 2")
            list += item
        }

        return list
    }

    fun insert(view : View) {

        val index = Random.nextInt(8)
        val newItem = ItemViewClass(R.drawable.ic_adb,
        "new item generated at $index",
            "line 2")
        list.add(index,newItem)
        adapter.notifyItemInserted(index)
    }

    fun remove(view : View) {
        val index = Random.nextInt(8)
        list.removeAt(index)
        adapter.notifyItemRemoved(index)
    }
}