package com.example.lendall.room.item

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*

class ItemRepository(application: Application) {
    private var itemDao: ItemDao
    init {
        val database = ItemDatabase.getInstance(application.applicationContext)
        itemDao = database!!.ItemDao()
    }
    fun insertItem(item: Item) =
        CoroutineScope(Dispatchers.IO).launch {
            itemDao.insert(item)
        }
    fun updateItem(item: Item) =
        CoroutineScope(Dispatchers.IO).launch {
            itemDao.update(item)
        }
    fun deleteItem(item: Item) =
        CoroutineScope(Dispatchers.IO).launch {
            itemDao.delete(item)
        }
    fun getAllItemAsync(): Deferred<LiveData<List<Item>>> =
        CoroutineScope(Dispatchers.IO).async {
            itemDao.getAllItem()
        }
    fun deleteAllRows() =
        CoroutineScope(Dispatchers.IO).launch {
            itemDao.deleteAllRows()
        }
    fun deleteRow (name_del: String, des_del: String, ace_del: String) =
            CoroutineScope(Dispatchers.IO).launch {
                itemDao.deleteRow(name_del, des_del, ace_del)
            }
    fun editItem (name_edit: String, des_edit: String, oldnameedit: String, olddesedit: String) =
        CoroutineScope(Dispatchers.IO).launch {
            itemDao.editItem(name_edit, des_edit, oldnameedit, olddesedit)
        }
    fun updateLendItem (ace_up: String, oldname_up: String) =
            CoroutineScope(Dispatchers.IO).launch {
                itemDao.updateLendItem(ace_up,oldname_up)
            }
}

//  fun editItem (id_edit: Int, name_edit: String, des_edit: String) =
//         CoroutineScope(Dispatchers.IO).launch {
//           itemDao.editItem(id_edit, name_edit, des_edit)
//      }
