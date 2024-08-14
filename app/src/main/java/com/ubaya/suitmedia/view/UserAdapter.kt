package com.ubaya.suitmedia.view

import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ubaya.suitmedia.databinding.UserItemBinding
import com.ubaya.suitmedia.model.User

class UserAdapter(val userList:ArrayList<User>, val sp: SharedPreferences): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(var binding:UserItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val picasso = Picasso.Builder(holder.itemView.context)
        picasso.listener { picasso, uri, exception ->
            exception.printStackTrace()
        }
        picasso.build().load(userList[position].image).into(holder.binding.imgAvatar)

        holder.binding.txtEmail.text = userList[position].email
        holder.binding.txtFname.text = userList[position].fname
        holder.binding.txtLname.text = userList[position].lname

        holder.binding.card.setOnClickListener {
            sp.edit().putString("selectedName", userList[position].fname + " " + userList[position].lname).apply()
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(newUserList:ArrayList<User>) {
        userList.clear()
        userList.addAll(newUserList)
        notifyDataSetChanged()
    }
}