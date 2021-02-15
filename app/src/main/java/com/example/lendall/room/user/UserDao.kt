package com.example.lendall.room.user
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("INSERT INTO User (us_firstname,us_lastname,us_adres,us_email,us_tel) VALUES (:FName_add, :LName_add, :Adres_add, :Email_add, :Tel_add)")
    fun insertUser(FName_add: String, LName_add: String, Adres_add: String, Email_add: String, Tel_add: String)

    @Query("SELECT * FROM User")
    fun getAllUser():LiveData<List<User>>

    @Query("DELETE FROM User")
    fun deleteAllUser()

    @Query("DELETE FROM User WHERE us_email = :Email_del AND us_tel = :Tel_del")
    suspend fun deleteRowUser(Email_del: String, Tel_del: String)

    @Query("UPDATE User SET us_firstname=:FName_edit, us_lastname=:LName_edit, us_adres=:Adres_edit, us_email=:Email_edit, us_tel=:Tel_edit WHERE us_adres=:OldAdres_edit AND us_email=:OldEmail_edit AND us_tel=:OldTel_edit")
    suspend fun editRowUser(FName_edit: String, LName_edit: String, Adres_edit: String, Email_edit: String, Tel_edit: String, OldAdres_edit: String, OldEmail_edit: String, OldTel_edit: String)

    @Query("SELECT * FROM User")
    fun getAllUserToSpinner(): LiveData<List<User>>

    @Query("SELECT * FROM User WHERE us_id = :userID")
    fun getUserId (userID: Int): LiveData<List<User?>?>?
}



// @Query("SELECT us_firstname, us_lastname FROM User")
// fun getUsers ():LiveData<List<User>>