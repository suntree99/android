package com.darma1budi.myrecyclerviewwithviewbinding_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.darma1budi.myrecyclerviewwithviewbinding_java.databinding.ItemRowHeroBinding;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {

    private ArrayList<Hero> listHero; // array untuk menampung data
    public ListHeroAdapter(ArrayList<Hero> list) { // fungsi untuk menampung data
        this.listHero = list;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder { // class wadah (holder)

//        Hapus kode-kode di bawah ini:
//        ImageView imgPhoto;
//        TextView tvName, tvDescription;

        ItemRowHeroBinding binding;

//        Hapus kode-kode di bawah ini:
//        public ListViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            imgPhoto = itemView.findViewById(R.id.img_item_photo);
//            tvName = itemView.findViewById(R.id.tv_item_name);
//            tvDescription = itemView.findViewById(R.id.tv_item_description);
//        }

        public ListViewHolder(ItemRowHeroBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
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
//        Hapus kode-kode di bawah ini:
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
        ItemRowHeroBinding binding =  ItemRowHeroBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ListViewHolder(binding);
    }

    /**  */
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) { /** onBindViewHolder() meletakan data pada wadah (holder) yang dibuat */
        Hero hero = listHero.get(position);
        holder.binding.tvItemName.setText(hero.getName());
        holder.binding.tvItemDescription.setText(hero.getDescription());
        holder.binding.imgItemPhoto.setImageResource(hero.getPhoto());

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