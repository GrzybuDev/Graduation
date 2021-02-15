package com.example.lendall.room.item
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {
    @Insert
    fun insert(item: Item)

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)

    @Query("SELECT * FROM Item")
    fun getAllItem():LiveData<List<Item>>

    @Query("DELETE FROM Item")
    fun deleteAllRows()

    @Query("DELETE FROM Item WHERE it_name = :name_del  AND it_des = :des_del AND it_ace = :ace_del")
    suspend fun deleteRow(name_del: String, des_del: String, ace_del: String)

   // @Query("UPDATE Item SET it_name = :name_edit, it_des = :des_edit WHERE it_id = :id_edit")
   // suspend fun editItem(id_edit: Int, name_edit: String, des_edit: String)

    @Query("UPDATE Item SET it_name = :name_edit, it_des = :des_edit WHERE it_name = :oldnameedit AND it_des = :olddesedit")
    suspend fun editItem(name_edit: String, des_edit: String, oldnameedit: String, olddesedit: String)

    @Query("UPDATE Item SET it_ace = :ace_up WHERE it_name = :oldname_up")
    suspend fun updateLendItem(ace_up: String, oldname_up: String)
}



