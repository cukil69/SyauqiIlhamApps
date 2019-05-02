package com.cukil.syauqiilhamapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cukil.syauqiilhamapps.databinding.ItemFriendBinding;
import com.cukil.syauqiilhamapps.databinding.ItemMusicBinding;
import com.cukil.syauqiilhamapps.model.Friend;
import com.cukil.syauqiilhamapps.model.Music;

import java.util.ArrayList;
import java.util.List;

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

        public void bind(Music item) {
            if (item != null) {
                int imgResId = binding.getRoot().getResources().getIdentifier(item.getImage(), "drawable", binding.getRoot().getContext().getPackageName());
                binding.imgMusicAlbum.setImageResource(imgResId);
                binding.txtMusicName.setText(item.getTitle());
                binding.txtMusicAlbum.setText(item.getArtist());
                binding.imgMusicPlaying.setVisibility(item.isPlaying() ? View.VISIBLE : View.GONE);
            }
        }
    }
}
