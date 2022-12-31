package com.darma1budi.skyobject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListPlanetAdapter(private val listPlanet: ArrayList<Planet>) : RecyclerView.Adapter<ListPlanetAdapter.ListViewHolder>() {

    // OnClick Item
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Planet)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPictures: ImageView = itemView.findViewById(R.id.img_item_picture)
        var tvNames: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescriptions: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_planet, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val planet = listPlanet[position]
        Glide.with(holder.itemView.context)
            .load(planet.picture)
            .apply(RequestOptions().override(100, 100))
            .into(holder.imgPictures)
        holder.tvNames.text = planet.name
        holder.tvDescriptions.text = planet.description

        // OnClick Item
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPlanet[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listPlanet.size
    }

}