package com.example.assignment_8.data.models

import com.example.assignment_8.data.vos.LoginVO

object LoginModelImpl: BaseModel(), LoginModel {

    override fun getAuth(onSuccess: (List<LoginVO>) -> Unit, onFailure: (String) -> Unit) {
        dataAgent.getAuth(onSuccess = {
            plantDB.loginDao().insertLoginUser(it)
        }, onFailure = {
            onFailure
        })
    }
}