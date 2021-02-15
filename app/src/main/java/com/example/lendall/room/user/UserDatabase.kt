package com.example.lendall.room.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun UserDao(): UserDao

    companion object{
        private var instance: UserDatabase? = null
        fun getInstance(context: Context): UserDatabase?{
            if (instance == null){
                instance = Room.databaseBuilder(
                        context,
                        UserDatabase::class.java,
                        "User")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance
        }
        fun deleteInstanceOfDatabase(){
            instance = null
        }

    }
}



