package com.example.lendall.adapters
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lendall.R
import com.example.lendall.page.user.UsDelPage
import com.example.lendall.page.user.UsEditPage
import com.example.lendall.page.user.UsShowPage
import com.example.lendall.room.user.User
class UserAdapter(private  val listUser: List<User>):RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.card_us_page,parent,false)
        return UserViewHolder(row)
    }
    override fun getItemCount(): Int {
       return listUser.size
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.us_idView.text = listUser[position].us_id.toString()
        holder.us_firstnameView.text = listUser[position].us_firstname
        holder.us_lastnameView.text = listUser[position].us_lastname
        holder.us_emailView.text = listUser[position].us_email
        holder.us_addressView.text = listUser[position].us_adres
        holder.us_telView.text = listUser[position].us_tel
    }
}
class UserViewHolder(val view: View):RecyclerView.ViewHolder(view) {
    val us_idView: TextView = view.findViewById(R.id.us_recycler_id)
    val us_firstnameView: TextView = view.findViewById(R.id.us_recycler_firstname)
    val us_lastnameView: TextView = view.findViewById(R.id.us_recycler_lastname)
    val us_addressView: TextView = view.findViewById(R.id.us_recycler_adres)
    val us_emailView: TextView = view.findViewById(R.id.us_recycler_email)
    val us_telView: TextView = view.findViewById(R.id.us_recycler_tel)
    val us_deleteBT: ImageButton = view.findViewById(R.id.UsPageDeleteButton)
    val us_editBT: ImageButton = view.findViewById(R.id.UsPageEditButton)
    val us_showBT: ImageButton = view.findViewById(R.id.UsPageShowButton)
    init {
        us_deleteBT.setOnClickListener {
            val intent = Intent(it.context, UsDelPage::class.java)
            intent.putExtra("us_id_del", us_idView.id)
            intent.putExtra("us_Fname_del",us_firstnameView.text)
            intent.putExtra("us_Lname_del", us_lastnameView.text)
            intent.putExtra("us_adres_del", us_addressView.text)
            intent.putExtra("us_email_del", us_emailView.text)
            intent.putExtra("us_tel_del", us_telView.text)
            it.context.startActivities(arrayOf(intent))
        }
        us_editBT.setOnClickListener {
            val intent = Intent(it.context, UsEditPage::class.java)
            intent.putExtra("us_id_edit", us_idView.id)
            intent.putExtra("us_Fname_edit",us_firstnameView.text)
            intent.putExtra("us_Lname_edit", us_lastnameView.text)
            intent.putExtra("us_adres_edit", us_addressView.text)
            intent.putExtra("us_email_edit", us_emailView.text)
            intent.putExtra("us_tel_edit", us_telView.text)
            it.context.startActivities(arrayOf(intent))
        }
        us_showBT.setOnClickListener {
            val intent = Intent(it.context, UsShowPage::class.java)
            intent.putExtra("us_id_show", us_idView.id)
            intent.putExtra("us_Fname_show",us_firstnameView.text)
            intent.putExtra("us_Lname_show", us_lastnameView.text)
            intent.putExtra("us_adres_show", us_addressView.text)
            intent.putExtra("us_email_show", us_emailView.text)
            intent.putExtra("us_tel_show", us_telView.text)
            it.context.startActivities(arrayOf(intent))
        }
    } }
