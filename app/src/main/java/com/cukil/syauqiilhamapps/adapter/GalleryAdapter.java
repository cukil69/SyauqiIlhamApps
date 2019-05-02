package com.cukil.syauqiilhamapps.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cukil.syauqiilhamapps.databinding.ItemGalleryBinding;
import com.cukil.syauqiilhamapps.model.Foto;
import com.cukil.syauqiilhamapps.view.GalleryViewerActivity;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ProfileInterestViewHolder> {

    private List<Foto> items = new ArrayList<>();

    public GalleryAdapter(List<Foto> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ProfileInterestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfileInterestViewHolder(ItemGalleryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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

        private ItemGalleryBinding binding;

        public ProfileInterestViewHolder(@NonNull ItemGalleryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final Foto item) {
            if (item != null) {
                binding.imgGalleryFoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(binding.imgGalleryFoto.getContext(), GalleryViewerActivity.class);
                        i.putExtra("image", item.getImage());
                        i.putExtra("desc", item.getDesc());
                        binding.imgGalleryFoto.getContext().startActivity(i);
                    }
                });
                Glide.with(binding.imgGalleryFoto.getContext()).load(item.getImage()).into(binding.imgGalleryFoto);
            }
        }
    }
}
