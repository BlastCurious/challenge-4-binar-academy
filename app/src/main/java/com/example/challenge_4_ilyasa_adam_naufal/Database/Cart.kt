package com.example.challenge_4_ilyasa_adam_naufal.Database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cart_menu")
data class Cart (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "food_name")
    var foodName: String,
    @ColumnInfo(name = "img_Id")
    var imgId: Int,
    @ColumnInfo(name ="food_Price")
    var priceMenu: Int,
    @ColumnInfo(name = "food_Quantity")
    var foodQuantity: Int,
    @ColumnInfo(name = "total_Price")
    var totalPrice: Int,
    @ColumnInfo(name = "food_Note")
    var foodNote: String? = null

):Parcelable
{

    companion object {
        const val TABLE_NAME = "cart_menu"
    }
}