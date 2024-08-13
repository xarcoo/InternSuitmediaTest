package com.ubaya.suitmedia.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("first_name")
    var fname:String,
    @SerializedName("last_name")
    var lname:String,
    var email:String,
    @SerializedName("avatar")
    var image:String
)