package com.example.assignment_8.network.responses

import com.example.assignment_8.data.vos.LoginVO
import com.example.assignment_8.utils.CODE_RESPONSE_OK
import com.google.gson.annotations.SerializedName

data class GetLoginResponse (

    @SerializedName("code")
    val code: Int,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: List<LoginVO>?
    ) {
        fun isResponseOK(): Boolean {
            return code == CODE_RESPONSE_OK && data != null
        }
    }