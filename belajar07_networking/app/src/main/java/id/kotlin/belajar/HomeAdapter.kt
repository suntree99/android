package id.kotlin.belajar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(private val results: List<Result>) : Adapter<HomeViewHolder>() {

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_home,
                    parent,
                    false
                )
        )
    }

    fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(results[holder.adapterPosition])
    }

    fun getItemCount(): Int {
        return results.count()
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(result: Result) {
            with(itemView) {
                val title = findViewById<TextView>(R.id.tv_title)
                title.text = result.title

                val overview = findViewById<TextView>(R.id.tv_overview)
                overview.text = result.overview
            }
        }
    }
}