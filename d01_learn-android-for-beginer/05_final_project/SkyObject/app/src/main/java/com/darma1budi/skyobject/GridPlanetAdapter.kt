package com.darma1budi.skyobject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridPlanetAdapter(private val listPlanet: ArrayList<Planet>) : RecyclerView.Adapter<GridPlanetAdapter.GridViewHolder>() {

    // OnClick Item
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Planet)
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPicture: ImageView = itemView.findViewById(R.id.img_item_picture)
        var tvNames: TextView = itemView.findViewById(R.id.tv_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_planet, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val planet = listPlanet[position]
        Glide.with(holder.itemView.context)
            .load(planet.picture)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPicture)
        holder.tvNames.text = planet.name

        // OnClick Item
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPlanet[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listPlanet.size
    }

}