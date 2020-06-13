package com.vickikbt.rickandmortyapp.views.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.vickikbt.rickandmortyapp.R
import com.vickikbt.rickandmortyapp.data.model.Characters
import com.vickikbt.rickandmortyapp.util.EnviromentVariables.Companion.TAG
import com.vickikbt.rickandmortyapp.viewmodel.CharactersViewModel
import com.vickikbt.rickandmortyapp.views.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CharactersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)

        loadData()

        /*main_viewpager.setOnPageChangeListener(ViewPager.OnPageChangeListener{

        })*/

    }

    private fun loadData() {
        viewModel.myData.observe(this, Observer {
            val characters = arrayListOf<Characters>()

            //val adapter = RecyclerViewAdapter(this, characters)
            val adapter = ViewPagerAdapter(this, characters)
            main_viewpager.setPadding(70,0,70,0)

            val results = it.body()!!.results
            for (i in results.indices) {
                characters.add(i, it.body()!!)
                //main_recyclerView.adapter = adapter
                main_viewpager.adapter=adapter
            }

            /*val next=it.body()!!.info.next
            val page=it.body()!!.info.pages

            if (next!=null && page !=null){
                loadData()
            }*/
        })
    }

}