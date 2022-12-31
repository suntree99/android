package com.darma1budi.skyobject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardPlanetAdapter(private val listPlanet: ArrayList<Planet>) : RecyclerView.Adapter<CardPlanetAdapter.CardViewHolder>() {

    // OnClick Item
    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var onBtnClickCallback: OnBtnClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setOnBtnClickCallback(onBtnClickCallback: OnBtnClickCallback) {
        this.onBtnClickCallback = onBtnClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Planet)
    }

    interface OnBtnClickCallback {
        fun onBtnClicked(data: Planet)
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPicture: ImageView = itemView.findViewById(R.id.img_item_picture)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card_planet, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val planet = listPlanet[position]
        Glide.with(holder.itemView.context)
            .load(planet.picture)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPicture)
        holder.tvName.text = planet.name
        holder.tvDescription.text = planet.description

        // OnClick Item
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPlanet[holder.adapterPosition]) }
        holder.btnShare.setOnClickListener { onBtnClickCallback.onBtnClicked(listPlanet[holder.adapterPosition]) }

        holder.btnFavorite.setOnClickListener { Toast.makeText(holder.itemView.context, "Kamu memfavoritkan " + listPlanet[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
    }

    override fun getItemCount(): Int {
        return listPlanet.size
    }

}