package com.darma1budi.githubuser2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.darma1budi.githubuser2.databinding.ItemRowUserBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<ItemsItem> list = new ArrayList<>();
    private OnItemClickCallback onItemClickCallback;
    public interface OnItemClickCallback { void onItemCLicked(ItemsItem data); }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private final ItemRowUserBinding itemRowBinding;

        public UserViewHolder(ItemRowUserBinding binding) {
            super(binding.getRoot());
            this.itemRowBinding = binding;
        }

        void bind(final ItemsItem user) {
            itemRowBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickCallback != null) {
                        onItemClickCallback.onItemCLicked(user);
                    }
                }
            });
            Glide.with(itemView)
                    .load(user.getAvatarUrl())
                    .centerCrop()
                    .into(itemRowBinding.imgItemAvatar);
            itemRowBinding.tvItemName.setText(user.getLogin());
        }
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRowUserBinding view = ItemRowUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
