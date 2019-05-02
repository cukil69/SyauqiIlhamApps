package com.cukil.syauqiilhamapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cukil.syauqiilhamapps.databinding.ItemVideoBinding;
import com.cukil.syauqiilhamapps.model.Video;

import java.util.ArrayList;
import java.util.List;

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

        public void bind(Video item) {
            if (item != null) {
                int imgResId = binding.getRoot().getResources().getIdentifier(item.getImage(), "drawable", binding.getRoot().getContext().getPackageName());
                binding.imgVideoAlbum.setImageResource(imgResId);
                binding.txtVideoName.setText(item.getTitle());
                binding.txtVideoArtist.setText(item.getArtist());
                binding.imgVideoPlaying.setVisibility(item.isPlaying() ? View.VISIBLE : View.GONE);
            }
        }
    }
}
