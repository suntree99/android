package com.darma1budi.githubuserssearch;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.darma1budi.githubuserssearch.databinding.ItemRowUserListBinding;

import java.util.List;

class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ListViewHolder> {
    private List<ItemsItem> userList;
    private OnItemClickCallback onItemClickCallBack;

    interface OnItemClickCallback {
        void onItemClicked(ItemsItem data);
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        ItemRowUserListBinding binding;

        ListViewHolder(ItemRowUserListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    UserListAdapter(List<ItemsItem> userList) {
        this.userList = userList;
    }

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallBack = onItemClickCallback;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRowUserListBinding binding = ItemRowUserListBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        ItemsItem user = userList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(user.getAvatarUrl())
                .circleCrop()
                .into(holder.binding.imgItemAvatar);
        holder.binding.tvItemName.setText(user.getLogin());
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickCallBack != null) {
                onItemClickCallBack.onItemClicked(userList.get(holder.getAdapterPosition()));
            }
        });
    }
}
