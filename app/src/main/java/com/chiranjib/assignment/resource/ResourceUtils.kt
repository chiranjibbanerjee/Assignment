package com.chiranjib.assignment.resource

import android.content.Context
import java.io.IOException
import java.io.InputStream

object ResourceUtils {
    fun getJsonFromAssets(context: Context, fileName: String?): String? {
        val jsonString: String
        jsonString = try {
            val `is`: InputStream? = fileName?.let { context.getAssets().open(it) }
            val size: Int? = `is`?.available()
            val buffer = size?.let { ByteArray(it) }
            `is`?.read(buffer)
            `is`?.close()
            if (buffer != null) {
                String(buffer)
            }
            else{

            }
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }.toString()
        return jsonString
    }
}