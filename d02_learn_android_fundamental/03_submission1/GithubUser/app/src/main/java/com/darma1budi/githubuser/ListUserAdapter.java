package com.darma1budi.githubuser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListViewHolder> {

    private ArrayList<User> listUser;
    public ListUserAdapter(ArrayList<User> list) {
        this.listUser = list;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCompany, tvLocation;
        ImageView ivAvatar;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_item_name);
            tvCompany = itemView.findViewById(R.id.tv_item_company);
            tvLocation = itemView.findViewById(R.id.tv_item_location);
            ivAvatar = itemView.findViewById(R.id.img_item_avatar);
        }
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_user, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        User user = listUser.get(position);
        holder.tvName.setText(user.getName());
        holder.tvCompany.setText(user.getCompany());
        holder.tvLocation.setText(user.getLocation());
        Glide.with(holder.itemView.getContext())
                .load(user.getAvatar())
                .circleCrop()
                .into(holder.ivAvatar);

        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listUser.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(User data);
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

}
