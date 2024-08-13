package com.ubaya.suitmedia.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.suitmedia.model.User
import org.json.JSONObject

class ThirdScreenViewModel(application: Application) : AndroidViewModel(application) {
    val userLD = MutableLiveData<ArrayList<User>>()
    val users = arrayListOf<User>()
    val emptyLoadLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        emptyLoadLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://reqres.in/api/users?page=1&per_page=12"

        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val obj = JSONObject(it)
                val data = obj.getJSONArray("data")

                for(i in 0 until data.length()) {
                    val playObj = data.getJSONObject(i)
                    users.add(
                        User(
                            playObj.getString("first_name"),
                            playObj.getString("last_name"),
                            playObj.getString("email"),
                            playObj.getString("avatar")
                        )
                    )
                }

//                val sType = object : TypeToken<List<User>>() {}.type
//                val result = Gson().fromJson<List<User>>(it, sType)

//                if (result.isEmpty()) emptyLoadLD.value = true

//                userLD.value = result as ArrayList<User>

                loadingLD.value = false
                if (users.isEmpty()) emptyLoadLD.value = true

                userLD.value = users
                users.clear()

                Log.d("User", it)
            },
            {
                loadingLD.value = false
                Log.e("apiresult", it.message.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}