package com.example.lendall.room.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(var us_firstname: String,
                var us_lastname: String,
                var us_adres: String,
                var us_email: String,
                var us_tel: String) {
@PrimaryKey(autoGenerate = true)
var us_id: Int = 0
}




