package com.example.lendall.adapters
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lendall.R
import com.example.lendall.page.item.ItDelPage
import com.example.lendall.page.item.ItEditPage
import com.example.lendall.page.item.ItGenPage
import com.example.lendall.room.item.Item
 class ItemAdapter(private val listItem: List<Item>):RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.card_it_page,parent,false)
        return MyViewHolder(row)
    }
    override fun getItemCount(): Int {
        return listItem.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.it_idView.text = listItem [position].it_id.toString()
        holder.it_nameView.text = listItem[position].it_name
        holder.it_desView.text = listItem[position].it_des
        holder.it_aceView.text = listItem[position].it_ace
    }
}
class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val it_idView: TextView = view.findViewById(R.id.it_recycler_id)
    val it_nameView: TextView = view.findViewById(R.id.it_recycler_name)
    val it_desView: TextView = view.findViewById(R.id.it_recycler_des)
    val it_aceView: TextView= view.findViewById(R.id.it_recycler_ace)
    val it_deleteBT: ImageButton = view.findViewById(R.id.ItPageDeleteButton)
    val it_editBT: ImageButton = view.findViewById(R.id.ItPageEditButton)
    val it_genBT: ImageButton = view.findViewById(R.id.ItPageQRButton)
    init {
        it_genBT.setOnClickListener {
            val intent = Intent(it.context, ItGenPage::class.java)
            intent.putExtra("it_id_gen", it_idView.id)
            intent.putExtra("it_name_gen", it_nameView.text)
            it.context.startActivity(intent)
        }
        it_deleteBT.setOnClickListener {
            val intent = Intent(it.context, ItDelPage::class.java)
            intent.putExtra("it_id_delete", it_idView.id)
            intent.putExtra("it_name_delete", it_nameView.text)
            intent.putExtra("it_des_delete", it_desView.text)
            intent.putExtra("it_ace_delete", it_aceView.text)
            it.context.startActivity(intent)
        }
        it_editBT.setOnClickListener {
            val intent =  Intent(it.context, ItEditPage::class.java)
            intent.putExtra("it_id_edit", it_idView.text)
            intent.putExtra("it_name_edit", it_nameView.text)
            intent.putExtra("it_des_edit", it_desView.text)
            intent.putExtra("it_ace_edit", it_aceView.text)
            it.context.startActivities(arrayOf(intent))
        }
    }
}



