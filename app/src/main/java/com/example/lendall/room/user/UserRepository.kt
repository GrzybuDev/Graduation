package com.example.lendall.room.user

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*

class UserRepository(application: Application) {
    private var userDao: UserDao
    init {
        val database = UserDatabase.getInstance(application.applicationContext)
        userDao = database!!.UserDao()
    }
    fun insertUsers(user: User) =
            CoroutineScope(Dispatchers.IO).launch {
                userDao.insert(user)
            }
   fun  insertUser(FName_add: String, LName_add: String, Adres_add: String, Email_add: String, Tel_add: String) =
           CoroutineScope(Dispatchers.IO).launch {
               userDao.insertUser(FName_add, LName_add, Adres_add, Email_add, Tel_add)
           }
    fun getAllUserAsync(): Deferred<LiveData<List<User>>> =
            CoroutineScope(Dispatchers.IO).async {
                userDao.getAllUser()
            }
    fun deleteAllUser() =
            CoroutineScope(Dispatchers.IO).launch {
                userDao.deleteAllUser()
            }
    fun deleteRowUser(Email_del: String, Tel_del: String) =
        CoroutineScope(Dispatchers.IO).launch {
            userDao.deleteRowUser(Email_del, Tel_del)
        }
    fun editRowUser(FName_edit: String, LName_edit: String, Adres_edit: String, Email_edit: String, Tel_edit: String, OldAdres_edit: String, OldEmail_edit: String, OldTel_edit: String) =
        CoroutineScope(Dispatchers.IO).launch {
            userDao.editRowUser(FName_edit, LName_edit, Adres_edit, Email_edit, Tel_edit, OldAdres_edit, OldEmail_edit, OldTel_edit)
        }

    fun getUserId (userID: Int) =
            CoroutineScope(Dispatchers.IO).launch {
                userDao.getUserId (userID)
            }
}



//val getAllUserToSpinner: LiveData<List<User>> = userDao.getAllUserToSpinner()


/* fun getAllUserToSpinner(): Deferred<ArrayList<List<User>>> =
           CoroutineScope(Dispatchers.IO).async {
               userDao.getAllUserToSpinner()
           }*/


// fun getUsers() =
//                CoroutineScope(Dispatchers.IO).launch {
//                    userDao.getUsers()
//        }