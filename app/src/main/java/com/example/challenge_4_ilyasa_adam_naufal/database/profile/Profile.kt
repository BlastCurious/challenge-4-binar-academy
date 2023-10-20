package com.example.challenge_4_ilyasa_adam_naufal.database.profile

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "profile")

data class Profile(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "email_user")
    var email: String,
    @ColumnInfo(name ="mobile_user")
    var mobile: String?,
    @ColumnInfo(name = "address_user")
    var address: String,
): Parcelable