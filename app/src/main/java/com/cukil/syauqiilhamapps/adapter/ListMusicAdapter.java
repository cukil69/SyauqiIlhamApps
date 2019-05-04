package com.cukil.syauqiilhamapps.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.cukil.syauqiilhamapps.databinding.ItemMusicBinding;
import com.cukil.syauqiilhamapps.model.Music;
import com.cukil.syauqiilhamapps.view.MusicViewerActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
    NIM          : 10116900
    Nama         : Syauqi Ilham Alfaraci
    Kelas        : IF-14K
    Tanggal buat : 01-05-2019
 */

public class ListMusicAdapter extends RecyclerView.Adapter<ListMusicAdapter.ProfileInterestViewHolder> {

    private List<Music> items = new ArrayList<>();

    public ListMusicAdapter(List<Music> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ProfileInterestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfileInterestViewHolder(ItemMusicBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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

        private ItemMusicBinding binding;

        public ProfileInterestViewHolder(@NonNull ItemMusicBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final Music item) {
            if (item != null) {
                Glide.with(binding.imgMusicAlbum).load(item.getImage()).into(binding.imgMusicAlbum);
                binding.txtMusicName.setText(item.getTitle());
                binding.txtMusicAlbum.setText(item.getArtist());
                binding.txtMusicDuration.setText(item.getDuration());
                binding.cntMusicContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(view.getContext(), MusicViewerActivity.class);
                        i.putExtra("image", item.getImage());
                        i.putExtra("title", item.getTitle());
                        i.putExtra("artist", item.getArtist());
                        i.putExtra("url", item.getUrl());
                        view.getContext().startActivity(i);
                    }
                });
            }
        }
    }
}
