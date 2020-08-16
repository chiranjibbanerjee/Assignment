package com.chiranjib.assignment.resource

import android.content.Context
import java.io.IOException
import java.io.InputStream

/**
 * Utility class to read the JSON file from the asset folder and parse the contents.
 * Gson Parser
 */


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