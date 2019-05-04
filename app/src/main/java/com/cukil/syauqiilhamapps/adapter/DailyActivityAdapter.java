package com.cukil.syauqiilhamapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cukil.syauqiilhamapps.databinding.ItemActivityBinding;
import com.cukil.syauqiilhamapps.databinding.ItemProfileInterestBinding;
import com.cukil.syauqiilhamapps.model.Activities;
import com.cukil.syauqiilhamapps.model.Interest;

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

public class DailyActivityAdapter extends RecyclerView.Adapter<DailyActivityAdapter.ProfileInterestViewHolder> {

    private List<Activities> items = new ArrayList<>();

    public DailyActivityAdapter(List<Activities> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ProfileInterestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfileInterestViewHolder(ItemActivityBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileInterestViewHolder holder, int position) {
        holder.bind(items.get(position), position == 0, position == items.size() - 1);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ProfileInterestViewHolder extends RecyclerView.ViewHolder {

        private ItemActivityBinding binding;

        public ProfileInterestViewHolder(@NonNull ItemActivityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Activities item, boolean isFirst, boolean isLast) {
            if (item != null) {
//                int imgResId = binding.getRoot().getResources().getIdentifier(item.getImage(), "drawable", binding.getRoot().getContext().getPackageName());
//                binding.imgItemProfileInterestImage.setImageResource(imgResId);
                binding.txtActivityTime.setText(item.getTime());
                binding.txtActivityLoc.setText(item.getLocation());
                binding.txtActivityDesc.setText(item.getDesc());
                binding.viewActivityLineTop.setVisibility(isFirst ? View.INVISIBLE : View.VISIBLE);
                binding.viewActivityLineBottom.setVisibility(isLast ? View.INVISIBLE : View.VISIBLE);
            }
        }
    }
}
