package com.example.assignment_8.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment_8.data.vos.LoginVO

@Dao
abstract class LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertLoginUser(loginVO: List<LoginVO>): LongArray

    @Query("SELECT * FROM login")
    abstract fun getLoginUser(): List<LoginVO>
}