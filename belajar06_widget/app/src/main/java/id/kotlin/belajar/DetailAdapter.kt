package id.kotlin.belajar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class DetailAdapter : Adapter<DetailAdapter.DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_detail,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class DetailViewHolder(itemView: View) : ViewHolder(itemView) {

        fun bind() {
            with(itemView) {
                val detailText = findViewById<TextView>(R.id.tv_detail)
                val text = "Hello RecyclerView! -> $adapterPosition"
                detailText.text = text
            }
        }
    }
}