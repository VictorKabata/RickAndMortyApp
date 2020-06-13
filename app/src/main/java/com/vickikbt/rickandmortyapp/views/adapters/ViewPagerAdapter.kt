package com.vickikbt.rickandmortyapp.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.vickikbt.rickandmortyapp.R
import com.vickikbt.rickandmortyapp.data.model.Characters

class ViewPagerAdapter(val context: Context, val characters: List<Characters>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int = characters.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.list_item, container, false)

        val imageViewCharacter: ImageView = view.findViewById(R.id.imageView_character)
        val textViewCharacter: TextView = view.findViewById(R.id.textView_character)
        val imageViewBackground: ImageView = view.findViewById(R.id.background_imageview)

        val imageURL = characters[position].results[position].image

        textViewCharacter.text = characters[position].results[position].name
        Glide.with(imageViewCharacter.context).load(imageURL).into(imageViewCharacter)
        Glide.with(imageViewBackground.context).load(imageURL).into(imageViewBackground)

        container.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}