package com.vickikbt.rickandmortyapp.views.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vickikbt.rickandmortyapp.R
import com.vickikbt.rickandmortyapp.data.model.Characters
import com.vickikbt.rickandmortyapp.viewmodel.CharactersViewModel
import com.vickikbt.rickandmortyapp.views.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CharactersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)

        main_recyclerView.setHasFixedSize(true)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        val characters = arrayListOf<Characters>()
        val adapter = RecyclerViewAdapter(this, characters)


        viewModel.myData.observe(this, Observer {
            val result = it.body()!!.results

            for (i in result.indices) {
                characters.add(i, it.body()!!)
                main_recyclerView.adapter = adapter
            }
        })
    }
}
