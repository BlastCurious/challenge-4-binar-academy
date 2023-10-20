package com.example.challenge_4_ilyasa_adam_naufal.database.profile

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProfileDAO {

    @Insert
    fun insert(data: Profile)

    @Query("SELECT * FROM profile WHERE email_user = :email")
    fun getProfile(email: String): LiveData<Profile>

}