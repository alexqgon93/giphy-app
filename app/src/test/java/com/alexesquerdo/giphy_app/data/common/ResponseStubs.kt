package com.alexesquerdo.giphy_app.data.common

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader

object ResponseStubs {
    private const val PATH = "/src/test/resources/raw/"

    private fun getResourceJson(fileName: String): String {
        return try {
            readFile(fileName)
        } catch (e: Exception) {
            "{}"
        }
    }

    @Throws(IOException::class)
    private fun readFile(path: String): String {
        var reader: BufferedReader? = null
        return try {
            val userDirPath = System.getProperty("user.dir")?.let { formatPath(it) }
            val fullPath = userDirPath + PATH + path
            reader = BufferedReader(InputStreamReader(FileInputStream(fullPath), "UTF-8"))
            reader.use { it.readText() }
        } catch (ignore: IOException) {
            ""
        } finally {
            reader?.close()
        }
    }

    private fun formatPath(path: String): String {
        val paths = path.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val listPaths = ArrayList(listOf(*paths))
        return if (listPaths.contains("app")) {
            path
        } else {
            path
        }
    }

    fun getResponseTrendingSuccess() = getResourceJson("trending/trendingSuccess.json")

    fun getResponseError() = getResourceJson("common/responseError.json")
}