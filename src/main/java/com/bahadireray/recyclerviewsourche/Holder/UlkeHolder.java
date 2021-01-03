package com.bahadireray.recyclerviewsourche.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bahadireray.recyclerviewsourche.R;


public class UlkeHolder extends RecyclerView.ViewHolder {

    public ImageView ivResim;
    public TextView tvUlkeAdi,tvUlkeKodu,tvUlkeBaskent,tvUlkeKurulus;

    public UlkeHolder(View itemView) {
        super(itemView);

        tvUlkeAdi = itemView.findViewById(R.id.tvUlkeAdi);
        tvUlkeKodu = itemView.findViewById(R.id.tvTelKodu);
        tvUlkeBaskent = itemView.findViewById(R.id.tvBaskent);
        tvUlkeKurulus = itemView.findViewById(R.id.tvKurulus);
        ivResim = itemView.findViewById(R.id.ivUlkeBayrak);
    }

}