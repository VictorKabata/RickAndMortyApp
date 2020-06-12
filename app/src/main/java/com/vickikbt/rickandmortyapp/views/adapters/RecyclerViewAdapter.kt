package com.vickikbt.rickandmortyapp.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vickikbt.rickandmortyapp.R
import com.vickikbt.rickandmortyapp.data.model.Characters

class RecyclerViewAdapter(val context: Context, private val characters: List<Characters>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageURL = characters[position].results[position].image

        holder.tvCharacter.text = characters[position].results[position].name
        Glide.with(holder.ivCharacter.context).load(imageURL).into(holder.ivCharacter)
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvCharacter: TextView = itemView.findViewById(R.id.textView_character)
    val ivCharacter: ImageView = itemView.findViewById(R.id.imageView_character)

}