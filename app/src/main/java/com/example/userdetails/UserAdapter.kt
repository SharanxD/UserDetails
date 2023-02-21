package com.example.userdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
//import com.example.userdetails.databinding.ActivityDbhelperBinding


class UsersAdapter(private val items : ArrayList<User>, private val context: Context) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout,parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder){
            with(items[position]) {
                holder.nameTextView.text = items[position].name
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        holder.itemView.context, "Age: $age\nPhone: $phone\nHobby: $hobby",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }



    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.username)
    }
}