package com.cukil.syauqiilhamapps.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cukil.syauqiilhamapps.databinding.ItemProfileInterestBinding;
import com.cukil.syauqiilhamapps.model.Interest;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileInterestAdapter extends RecyclerView.Adapter<ProfileInterestAdapter.ProfileInterestViewHolder> {

    private List<Interest> items = new ArrayList<>();

    public ProfileInterestAdapter(List<Interest> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ProfileInterestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfileInterestViewHolder(ItemProfileInterestBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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

        private ItemProfileInterestBinding binding;

        public ProfileInterestViewHolder(@NonNull ItemProfileInterestBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Interest item) {
            if (item != null) {
                int imgResId = binding.getRoot().getResources().getIdentifier(item.getImage(), "drawable", binding.getRoot().getContext().getPackageName());
                binding.imgItemProfileInterestImage.setImageResource(imgResId);
                binding.txtItemProfileInterestName.setText(item.getName());
            }
        }
    }
}
