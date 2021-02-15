package com.example.lendall.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.lendall.room.user.User
import com.example.lendall.room.user.UserRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking

class UserViewModel(application: Application):
AndroidViewModel(application){

    private var userRepository: UserRepository =
            UserRepository(application)
    private var allUser:Deferred<LiveData<List<User>>> =
            userRepository.getAllUserAsync()

    fun insertUsers(user: User){
        userRepository.insertUsers(user)
    }

    fun insertUser(FName_add: String, LName_add: String, Adres_add: String
                   , Email_add: String, Tel_add: String) {
        userRepository.insertUser(FName_add, LName_add, Adres_add, Email_add, Tel_add)
    }

    fun getAllUser(): LiveData<List<User>> = runBlocking {
        allUser.await()
    }

    fun deleteAllUser(){
        userRepository.deleteAllUser()
    }

    fun deleteRowUser(Email_del: String, Tel_del: String){
        userRepository.deleteRowUser(Email_del, Tel_del)
    }
    fun editRowUser(FName_edit: String, LName_edit: String, Adres_edit: String
                    , Email_edit: String, Tel_edit: String, OldAdres_edit: String
                    , OldEmail_edit: String, OldTel_edit: String) {
        userRepository.editRowUser(FName_edit, LName_edit, Adres_edit
                , Email_edit, Tel_edit, OldAdres_edit, OldEmail_edit, OldTel_edit)
    }
}



//private val mSpinnerData = MutableLiveData<List<User>>()
// fun
/*private var allUserSpinner: Deferred<ArrayList<List<User>>> =
        userRepository.getAllUserToSpinner()
*/


/*fun getAllUserToSpinner():ArrayList<List<User>> = runBlocking {
      allUserSpinner.await()
  }
  */

/*
fun getUserId (userID: Int) {
    userRepository.getUserId (userID)
}
*/


// fun getUsers() {
//     userRepository.getUsers()
// }