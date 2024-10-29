package com.alfin.mental

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alfin.mental.data.Mental
import com.dendi.organ.R
import com.alfin.mental.`object`.DataMental

import com.alfin.mental.view.Detail
import com.alfin.mental.view.MentalViewAdapter
import com.alfin.mental.view.Profil

class MainActivity : AppCompatActivity() {
    private lateinit var rvViews: RecyclerView
    private var listMental: ArrayList<Mental> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvViews = findViewById(R.id.rv_heroes)
        rvViews.setHasFixedSize(true)

        listMental.addAll(DataMental.listData)
        showRecyclerCardView()
    }

    private fun showRecyclerCardView() {
        rvViews.layoutManager = LinearLayoutManager(this)
        val cardViewMental = MentalViewAdapter(listMental)
        rvViews.adapter = cardViewMental

        cardViewMental.setOnItemClickCallback(object : MentalViewAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Mental) {
                showOrganSelected(data)
            }
        })

        cardViewMental.setOnButtonClickCallback(object : MentalViewAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Mental) {
                sendMessage(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                myProfil()
            }
        }
    }

    private fun myProfil(){
        val intent = Intent(this, Profil::class.java)
        startActivity(intent)
    }

    private fun showOrganSelected(mental: Mental) {
        Toast.makeText(this, "Kamu memilih " + mental.name, Toast.LENGTH_SHORT).show()
        val moveData = Intent(this, Detail::class.java)
        moveData.putExtra(Detail.EXTRA_NAME, mental.name)
        moveData.putExtra(Detail.EXTRA_IMAGE, mental.photo)
        moveData.putExtra(Detail.EXTRA_DETAIL, mental.detail)
        startActivity(moveData)
    }

    private fun sendMessage(mental: Mental){
        val judul = mental.name
        val latinName = mental.latinName
        val detail = mental.detail

        val message = "Nama Mental : *$judul*,\nNama Latin : _" + latinName +"_,\n \n$detail"

        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, message)
        intent.type = "text/plain"

        startActivity(Intent.createChooser(intent, "Share using .."))
    }
}
