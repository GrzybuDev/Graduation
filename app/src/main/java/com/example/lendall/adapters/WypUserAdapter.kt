package com.example.lendall.adapters
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lendall.R
import com.example.lendall.page.lenditem.WypAddPage
import com.example.lendall.page.lenditem.WypShowPage
import com.example.lendall.room.user.User
class WypUserAdapter(private  val listUser: List<User>):RecyclerView.Adapter<WypUserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WypUserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowWypPage = layoutInflater.inflate(R.layout.card_us_wyp_page,parent,false)
        return WypUserViewHolder(rowWypPage)
    }
    override fun getItemCount(): Int {
        return listUser.size
    }
    override fun onBindViewHolder(holder: WypUserViewHolder, position: Int) {
        holder.wyp_us_idView.text = listUser[position].us_id.toString()
        holder.wyp_us_firstnameView.text = listUser[position].us_firstname
        holder.wyp_us_lastnameView.text = listUser[position].us_lastname
        holder.wyp_us_emailView.text = listUser[position].us_email
        holder.wyp_us_addressView.text = listUser[position].us_adres
        holder.wyp_us_telView.text = listUser[position].us_tel
    }
}
class WypUserViewHolder(val view: View):RecyclerView.ViewHolder(view) {
    val wyp_us_idView: TextView = view.findViewById(R.id.wyp_us_recycler_id)
    val wyp_us_firstnameView: TextView = view.findViewById(R.id.wyp_us_recycler_firstname)
    val wyp_us_lastnameView: TextView = view.findViewById(R.id.wyp_us_recycler_lastname)
    val wyp_us_addressView: TextView = view.findViewById(R.id.wyp_us_recycler_adres)
    val wyp_us_emailView: TextView = view.findViewById(R.id.wyp_us_recycler_email)
    val wyp_us_telView: TextView = view.findViewById(R.id.wyp_us_recycler_tel)
    val wyp_us_selectBT: ImageButton = view.findViewById(R.id.WypUsPageSelect)
    val wyp_us_showBT: ImageButton = view.findViewById(R.id.WypUsPageShowButton)
    init{
        wyp_us_selectBT.setOnClickListener {
            val intent = Intent(it.context, WypAddPage::class.java)
            intent.putExtra("wyp_us_id_add", wyp_us_idView.id)
            intent.putExtra("wyp_us_Fname_add", wyp_us_firstnameView.text)
            intent.putExtra("wyp_us_Lname_add", wyp_us_lastnameView.text)
            intent.putExtra("wyp_us_adres_add", wyp_us_addressView.text)
            intent.putExtra("wyp_us_email_add", wyp_us_emailView.text)
            intent.putExtra("wyp_us_tel_add", wyp_us_telView.text)
            it.context.startActivities(arrayOf(intent))
        }
        wyp_us_showBT.setOnClickListener {
            val intent = Intent(it.context, WypShowPage::class.java)
            intent.putExtra("wyp_us_id_show", wyp_us_idView.id)
            intent.putExtra("wyp_us_Fname_show", wyp_us_firstnameView.text)
            intent.putExtra("wyp_us_Lname_show", wyp_us_lastnameView.text)
            intent.putExtra("wyp_us_adres_show", wyp_us_addressView.text)
            intent.putExtra("wyp_us_email_show", wyp_us_emailView.text)
            intent.putExtra("wyp_us_tel_show", wyp_us_telView.text)
            it.context.startActivities(arrayOf(intent))
        }
    }
}

