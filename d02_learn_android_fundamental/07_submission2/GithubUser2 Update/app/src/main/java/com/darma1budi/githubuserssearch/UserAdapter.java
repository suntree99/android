package com.darma1budi.githubuserssearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.darma1budi.githubuserssearch.databinding.ItemRowUserBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private final ArrayList<User> listUser;
    public UserAdapter(ArrayList<User> list) {
        this.listUser = list;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
//        TextView tvName, tvCompany, tvLocation;
//        ImageView ivAvatar;
//
//        public UserViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            tvName = itemView.findViewById(R.id.tv_item_name);
//            tvCompany = itemView.findViewById(R.id.tv_item_company);
//            tvLocation = itemView.findViewById(R.id.tv_item_location);
//            ivAvatar = itemView.findViewById(R.id.img_item_avatar);
//        }

        private ItemRowUserBinding itemRowBinding;

        public UserViewHolder(@NonNull ItemRowUserBinding binding) {
            super(binding.getRoot());

            this.itemRowBinding = binding;
        }

        // Fungsi tambahan
//        void bind(final ItemsItem user) {
//            itemRowBinding.getRoot().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (onItemClickCallback != null) {
//                        onItemClickCallback.onItemCLicked(user);
//                    }
//                }
//            });
//            Glide.with(itemView)
//                    .load(user.getAvatarUrl())
//                    .centerCrop()
//                    .into(itemRowBinding.imgItemAvatar);
//            itemRowBinding.tvItemName.setText(user.getLogin());
//        }
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_user, parent, false);
//        return new UserViewHolder(view);

        ItemRowUserBinding viewItemRow = ItemRowUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserViewHolder(viewItemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = listUser.get(position);

//        holder.tvName.setText(user.getName());
//        holder.tvCompany.setText(user.getCompany());
//        holder.tvLocation.setText(user.getLocation());
//        Glide.with(holder.itemView.getContext())
//                .load(user.getAvatar())
//                .circleCrop()
//                .into(holder.ivAvatar);

        holder.itemRowBinding.tvItemName.setText(user.getName());
        holder.itemRowBinding.tvItemCompany.setText(user.getCompany());
        holder.itemRowBinding.tvItemLocation.setText(user.getLocation());
        Glide.with(holder.itemView.getContext())
                .load(user.getAvatar())
                .circleCrop()
                .into(holder.itemRowBinding.imgItemAvatar);

//        itemRowBinding.tvItemName.setText(user.getLogin());
//        itemRowBinding.getRoot().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onItemClickCallback != null) {
//                    onItemClickCallback.onItemCLicked(user);
//                }
//            }
//        });
//        Glide.with(itemView)
//                .load(user.getAvatarUrl())
//                .centerCrop()
//                .into(itemRowBinding.imgItemAvatar);

        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listUser.get(holder.getAdapterPosition())));

//        holder.bind(list.get(position));

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
