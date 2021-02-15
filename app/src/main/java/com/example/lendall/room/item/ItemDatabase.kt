package com.example.lendall.room.item

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 2, exportSchema = false)
abstract class ItemDatabase: RoomDatabase() {
   abstract fun ItemDao(): ItemDao

   companion object{
       private var instance: ItemDatabase? = null
       fun getInstance(context: Context): ItemDatabase?{
           if(instance == null){
               instance = Room.databaseBuilder(
                   context,
                   ItemDatabase::class.java,
                   "Item")
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



