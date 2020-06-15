package com.vickikbt.rickandmortyapp.views.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vickikbt.rickandmortyapp.R
import com.vickikbt.rickandmortyapp.data.model.Characters
import com.vickikbt.rickandmortyapp.util.EnviromentVariables

class RecyclerViewAdapter(val context: Context, val characters: List<Characters>) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = characters[position].results[position]
        val imageURL = data.image

        Glide.with(holder.imageViewCharacter.context).load(imageURL).into(holder.imageViewCharacter)
        holder.textViewCharacter.text = data.name
        holder.textViewLocation.text = data.species

        Log.e(EnviromentVariables.TAG, data.toString())
    }

}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageViewCharacter: ImageView = itemView.findViewById(R.id.imageView_character)
    val textViewCharacter: TextView = itemView.findViewById(R.id.textView_character_name)
    val textViewLocation: TextView = itemView.findViewById(R.id.textView_character_location)
}