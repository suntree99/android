package com.darma1budi.myrecyclerview_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {

    private ArrayList<Hero> listHero; // array untuk menampung data
    public ListHeroAdapter(ArrayList<Hero> list) { // fungsi untuk menampung data
        this.listHero = list;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder { // class wadah (holder)

        ImageView imgPhoto;
        TextView tvName, tvDescription;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) { // fungsi callback onClick
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback { // interface untuk onCLick
        void onItemClicked(Hero data);
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { /** onCreateViewHolder() membuat wadah (holder) untuk menampilkan data */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
        return new ListViewHolder(view);
    }

    /**  */
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) { /** onBindViewHolder() meletakan data pada wadah (holder) yang dibuat */
        Hero hero = listHero.get(position);
        holder.tvName.setText(hero.getName());
        holder.tvDescription.setText(hero.getDescription());
        holder.imgPhoto.setImageResource(hero.getPhoto());

        /** Fungsi onClick ditrigger dari item recyclerView */
//        holder.itemView.setOnClickListener(v -> {
//            Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listHero.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
//        });

        /** Fungsi onClick ditrigger dari Activity */
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listHero.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() { /** getItemCount() mengembalikan jumlah data yang ditampilkan */
        return listHero.size();
    }
}