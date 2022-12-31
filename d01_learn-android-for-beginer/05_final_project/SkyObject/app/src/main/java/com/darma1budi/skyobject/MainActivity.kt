package com.darma1budi.skyobject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var rvPlanets: RecyclerView
    private var list: ArrayList<Planet> = arrayListOf()
    private var title: String = "Sky Object"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvPlanets = findViewById(R.id.rv_planets)
        rvPlanets.setHasFixedSize(true)

        list.addAll(PlanetsData.listData)
        showRecyclerList()
    }

    // Recycle View
    private fun showRecyclerList() {
        rvPlanets.layoutManager = LinearLayoutManager(this)
        val listPlanetAdapter = ListPlanetAdapter(list)
        rvPlanets.adapter = listPlanetAdapter

        listPlanetAdapter.setOnItemClickCallback(object : ListPlanetAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Planet) {
                showSelectedPlanet(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvPlanets.layoutManager = GridLayoutManager(this, 2)
        val gridPlanetAdapter = GridPlanetAdapter(list)
        rvPlanets.adapter = gridPlanetAdapter

        gridPlanetAdapter.setOnItemClickCallback(object : GridPlanetAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Planet) {
                showSelectedPlanet(data)
            }
        })
    }

    private fun showRecyclerCard() {
        rvPlanets.layoutManager = LinearLayoutManager(this)
        val cardPlanetAdapter = CardPlanetAdapter(list)
        rvPlanets.adapter = cardPlanetAdapter

        cardPlanetAdapter.setOnItemClickCallback(object : CardPlanetAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Planet) {
                showSelectedPlanet(data)
            }
        })

        cardPlanetAdapter.setOnBtnClickCallback(object : CardPlanetAdapter.OnBtnClickCallback {
            override fun onBtnClicked(data: Planet) {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,
                        data.name.uppercase() + "\n\n" +
                                "Radius Rata-rata : " + data.averageRadius + " km\n" +
                                "Massa : " + data.mass + " kg\n" +
                                "Area Permukaan : " + data.surfaceArea + " km2\n" +
                                "Gravitasi : " + data.gravity + " m/s2\n" +
                                "Jarak dari Matarari : " + data.distanceFromSun + " km\n" +
                                "Waktu Rotasi : " + data.rotationTime + "\n" +
                                "Bulan : " + data.moon
                    )
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        })
    }

    // Bar Title
    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    // Menu
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
                title = "Sky Object"
                showRecyclerList()
            }

            R.id.action_grid -> {
                title = "Sky Object : Grid"
                showRecyclerGrid()
            }

            R.id.action_card -> {
                title = "Sky Object : Card"
                showRecyclerCard()
            }

            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        setActionBarTitle(title)
    }

    private fun showSelectedPlanet(planet: Planet) {
        val moveWithDataPlanet = Intent(this@MainActivity, DetailActivity::class.java)
        moveWithDataPlanet.putExtra("EXTRA_NAME", planet.name)
        moveWithDataPlanet.putExtra("EXTRA_DESCRIPTION", planet.description)
        moveWithDataPlanet.putExtra("EXTRA_PICTURE", planet.picture)
        moveWithDataPlanet.putExtra("EXTRA_VIDEO", planet.video)
        moveWithDataPlanet.putExtra("EXTRA_RADIUS", planet.averageRadius)
        moveWithDataPlanet.putExtra("EXTRA_MASS", planet.mass)
        moveWithDataPlanet.putExtra("EXTRA_AREA", planet.surfaceArea)
        moveWithDataPlanet.putExtra("EXTRA_GRAVITY", planet.gravity)
        moveWithDataPlanet.putExtra("EXTRA_DISTANCE", planet.distanceFromSun)
        moveWithDataPlanet.putExtra("EXTRA_ROTATION", planet.rotationTime)
        moveWithDataPlanet.putExtra("EXTRA_MOON", planet.moon)
        startActivity(moveWithDataPlanet)
    }
}