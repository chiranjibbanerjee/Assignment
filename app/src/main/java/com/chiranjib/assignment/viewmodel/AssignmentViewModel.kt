package com.chiranjib.assignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.chiranjib.assignment.model.Response
import com.chiranjib.assignment.resource.ResourceUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * Class to fetch response from the JSON file.
 */
class AssignmentViewModel(application: Application) :AndroidViewModel(application) {

    var mResponseData=MutableLiveData<Response>()

    fun getData(){

        val jsonFileString =
            ResourceUtils.getJsonFromAssets(getApplication(), "canadaresource.json")

        val gson = Gson()
        val listDataType: Type = object : TypeToken<Response>() {}.type

        val getrespoonsefromasset: Response = gson.fromJson(jsonFileString, listDataType)
        mResponseData.value=getrespoonsefromasset
    }

}