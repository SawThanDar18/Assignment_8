package com.example.assignment_8.data.models

import com.example.assignment_8.data.vos.LoginVO

interface LoginModel {

    fun getAuth(onSuccess: (List<LoginVO>) -> Unit,
                onFailure: (String) -> Unit)
}