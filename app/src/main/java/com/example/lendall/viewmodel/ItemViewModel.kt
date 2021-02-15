package com.example.lendall.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.lendall.room.item.Item
import com.example.lendall.room.item.ItemRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
class ItemViewModel(application: Application):
    AndroidViewModel(application) {

    private var itemRepository: ItemRepository =
        ItemRepository(application)
    private var allItem: Deferred<LiveData<List<Item>>> =
        itemRepository.getAllItemAsync()

    fun insertItem(item: Item) {
        itemRepository.insertItem(item)
    }

    fun updateItem(item: Item) {
        itemRepository.updateItem(item)
    }

    fun deleteItem(item: Item) {
        itemRepository.deleteItem(item)
    }

    fun getAllItem(): LiveData<List<Item>> = runBlocking {
        allItem.await()
    }

    fun deleteAllRows() {
        itemRepository.deleteAllRows()
    }

    fun deleteRow(name_del: String, des_del: String, ace_del: String) {
        itemRepository.deleteRow(name_del, des_del, ace_del)
    }

    fun editItem (name_edit: String, des_edit: String, oldnameedit: String, olddesedit: String) {
            itemRepository.editItem(name_edit, des_edit, oldnameedit, olddesedit)
      }

    fun updateLendItem (ace_up: String, oldname_up: String) {
                itemRepository.updateLendItem(ace_up,oldname_up)
            }
}


//fun editItem(id_edit: Int, name_edit: String, des_edit: String) {
//    itemRepository.editItem(id_edit, name_edit, des_edit)
//}