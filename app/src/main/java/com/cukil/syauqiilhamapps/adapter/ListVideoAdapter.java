package com.cukil.syauqiilhamapps.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.cukil.syauqiilhamapps.databinding.ItemVideoBinding;
import com.cukil.syauqiilhamapps.model.Video;
import com.cukil.syauqiilhamapps.view.VideoViewerActivity;

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

public class ListVideoAdapter extends RecyclerView.Adapter<ListVideoAdapter.ProfileInterestViewHolder> {

    private List<Video> items = new ArrayList<>();

    public ListVideoAdapter(List<Video> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ProfileInterestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfileInterestViewHolder(ItemVideoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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

        private ItemVideoBinding binding;

        public ProfileInterestViewHolder(@NonNull ItemVideoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final Video item) {
            if (item != null) {
                Glide.with(binding.imgVideoAlbum).load(item.getImage()).into(binding.imgVideoAlbum);
                binding.txtVideoName.setText(item.getTitle());
                binding.txtVideoArtist.setText(item.getArtist());
                binding.txtVideoDuration.setText(item.getDuration());
                binding.cntVideoContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(view.getContext(), VideoViewerActivity.class);
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
