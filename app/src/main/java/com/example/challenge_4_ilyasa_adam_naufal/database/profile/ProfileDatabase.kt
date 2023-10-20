package com.example.challenge_4_ilyasa_adam_naufal.database.profile

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Profile::class], version = 1)
abstract class ProfileDatabase: RoomDatabase()  {

    abstract fun profileDAO(): ProfileDAO

    companion object {

        @Volatile
        private var INSTANCE: ProfileDatabase? = null

        fun getInstance(context: Context): ProfileDatabase {
            synchronized(this){
                    var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                        ProfileDatabase::class.java,"profile_database"
                    )
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}