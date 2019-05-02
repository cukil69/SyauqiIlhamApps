package com.cukil.syauqiilhamapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cukil.syauqiilhamapps.databinding.ItemActivityBinding;
import com.cukil.syauqiilhamapps.databinding.ItemFriendBinding;
import com.cukil.syauqiilhamapps.model.Activities;
import com.cukil.syauqiilhamapps.model.Friend;

import java.util.ArrayList;
import java.util.List;

public class ListFriendAdapter extends RecyclerView.Adapter<ListFriendAdapter.ProfileInterestViewHolder> {

    private List<Friend> items = new ArrayList<>();

    public ListFriendAdapter(List<Friend> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ProfileInterestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfileInterestViewHolder(ItemFriendBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileInterestViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ProfileInterestViewHolder extends RecyclerView.ViewHolder {

        private ItemFriendBinding binding;

        public ProfileInterestViewHolder(@NonNull ItemFriendBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Friend item) {
            if (item != null) {
//                int imgResId = binding.getRoot().getResources().getIdentifier(item.getImage(), "drawable", binding.getRoot().getContext().getPackageName());
//                binding.imgItemProfileInterestImage.setImageResource(imgResId);
                Glide.with(binding.imgFriendFoto.getContext()).load(item.getImage()).into(binding.imgFriendFoto);
                binding.txtFriendName.setText(item.getName());
                binding.txtFriendLoc.setText(item.getAddress());
                binding.txtFriendPhone.setText(item.getPhone());
            }
        }
    }
}
