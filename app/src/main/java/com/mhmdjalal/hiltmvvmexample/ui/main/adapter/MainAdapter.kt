package com.mhmdjalal.hiltmvvmexample.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mhmdjalal.hiltmvvmexample.R
import com.mhmdjalal.hiltmvvmexample.data.model.Character
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private var users: List<Character> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindItem(users[position])
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: Character) = with(itemView) {
            textViewUserName.text = item.name
            textViewUserEmail.text = "${item.species} - ${item.status}"
            Glide.with(this)
                .load(item.image)
                .error(android.R.color.darker_gray)
                .into(imageViewAvatar)
        }
    }

    fun addData(list: List<Character>) {
        users = list
    }
}