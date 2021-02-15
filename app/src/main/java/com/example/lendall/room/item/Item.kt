package com.example.lendall.room.item
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = arrayOf(Index(value = ["it_name"], unique = true)))
data class Item(
      /*  @PrimaryKey(autoGenerate = true)
        var it_id: Int = 0,*/
        var it_name:String,
        var it_des:String,
        var it_ace: String)
{
    @PrimaryKey(autoGenerate = true)
    var it_id: Int = 0
}



//@Entity(tableName = "Item")
/*@ColumnInfo(name = "it_name")
    var it_name: String?,
    @ColumnInfo(name = "it_des")
    var it_des:String?,
    @ColumnInfo(name = "it_ace")
    var it_ace:String?)
    */