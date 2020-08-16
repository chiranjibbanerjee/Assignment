package com.chiranjib.assignment.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.chiranjib.assignment.R
import com.chiranjib.assignment.listadapter.NewsAdapter
import com.chiranjib.assignment.viewmodel.AssignmentViewModel
import kotlinx.android.synthetic.main.activity_main.*

lateinit var assignmentViewModel: AssignmentViewModel

/**
 * Starting point of the Android application
 */
class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(
               applicationContext, // Context
                LinearLayout.VERTICAL, // Orientation
                false // Reverse layout
        )

        list.layoutManager = linearLayoutManager
        assignmentViewModel =ViewModelProviders.of(this).get(AssignmentViewModel::class.java)
        assignmentViewModel.mResponseData.observe(this, Observer {

            list.adapter= it.rows?.let { itrow -> NewsAdapter(itrow,applicationContext) }
            it?.title?.let {
                // Load Title
               setTitle(it)
            }

        })

        getDataFromAsset()
        floatingActionButton.setOnClickListener {
            getDataFromAsset()
        }

    }

    fun getDataFromAsset(){
        assignmentViewModel.getData()
    }
}