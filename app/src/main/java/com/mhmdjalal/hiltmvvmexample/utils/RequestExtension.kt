package com.mhmdjalal.hiltmvvmexample.utils

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response

fun <T> request(coroutineScope: CoroutineScope, response: suspend() -> Response<T>, results:(Resource<T>) -> Unit) {
    try {
        coroutineScope.launch {
            handlingResponse(response, {
                results(it)
            })
        }
    } catch (e: Exception) {
        Log.e("REQUEST_FAILED","not sending request")
        Log.e("REQUEST_FAILED","${e.message}")
    }
}

suspend fun <T> handlingResponse(response: suspend() -> Response<T>, results:(Resource<T>) -> Unit) {
    try {
        val result = response()
        if (result.isSuccessful) {
            result.body()?.let { body ->
                results(Resource.success(body))
            }
        } else {
            val xbody = result.errorBody()?.string()
            var xpesan = "Tidak dapat menghubungi server, pastikan koneksi internet anda stabil"
            try {
                val resError = JSONObject(xbody)
                if (resError.has("message"))
                    xpesan = resError.getString("message")
            } catch (e: Exception) {
                Log.e("RESULTTHROW1", "error $e")
                xpesan = "Gagal terhubung dengan server"
            }
            Log.d("RESULT"," $xpesan")
            results(Resource.error(xpesan, null))
        }
    } catch (throwable: Throwable) {
        println("RESULTTHROW $throwable")
        results(Resource.error("Gagal terhubung dengan server", null))
    }
}