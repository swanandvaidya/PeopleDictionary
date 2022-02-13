package com.swanandvaidya.peopledictionary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swanandvaidya.peopledictionary.data.User
import com.swanandvaidya.peopledictionary.databinding.ListItemUserBinding

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private var userList = mutableListOf<User>()
    private lateinit var userBinding: ListItemUserBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        userBinding =
            ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(userBinding.root)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            userBinding.userModel = user
        }
    }

    fun submitUserList(usersList: List<User>) {
        this.userList = usersList.toMutableList()
        notifyDataSetChanged()
    }
}