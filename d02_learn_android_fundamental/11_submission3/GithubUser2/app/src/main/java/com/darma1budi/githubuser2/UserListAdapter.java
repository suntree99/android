package com.darma1budi.githubuser2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.darma1budi.githubuser2.databinding.ItemRowUserBinding;

import java.util.List;

class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ListViewHolder> {
    private List<ItemsItem> personList;
    private OnItemClickCallback onItemClickCallBack;

    interface OnItemClickCallback {
        void onItemClicked(ItemsItem data);
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        ItemRowUserBinding binding;

        ListViewHolder(ItemRowUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    UserListAdapter(List<ItemsItem> personList) {
        this.personList = personList;
    }

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallBack = onItemClickCallback;
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRowUserBinding binding = ItemRowUserBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        ItemsItem person = personList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(person.getAvatarUrl())
                .into(holder.binding.imgItemAvatar);
        holder.binding.tvItemName.setText(person.getLogin());
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickCallBack != null) {
                onItemClickCallBack.onItemClicked(personList.get(holder.getAdapterPosition()));
            }
        });
    }
}
