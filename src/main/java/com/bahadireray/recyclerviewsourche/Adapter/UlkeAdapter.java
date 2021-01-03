package com.bahadireray.recyclerviewsourche.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bahadireray.recyclerviewsourche.Holder.UlkeHolder;
import com.bahadireray.recyclerviewsourche.Model.Ulke;
import com.bahadireray.recyclerviewsourche.R;

import java.util.ArrayList;
import java.util.List;

public class UlkeAdapter extends RecyclerView.Adapter<UlkeHolder> implements Filterable {

    private List<Ulke> items;
    private List<Ulke> itemsFiltered;
    private Context context;

    public UlkeAdapter(){}


    public UlkeAdapter(List<Ulke> ulkeler,Context context){
        this.context = context;
        this.items = ulkeler;
        this.itemsFiltered = ulkeler;
    }


    @NonNull
    @Override
    public UlkeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.satir_goruntusu,null);

        return new UlkeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UlkeHolder holder, int position) {

        int resId = holder
                .itemView
                .getResources()
                .getIdentifier(
                        itemsFiltered.get(position).getUlkeResimUrl(),
                        "drawable",
                        context.getPackageName()
                );
        holder.ivResim.setImageResource(resId);
        holder.tvUlkeKurulus.setText(""+itemsFiltered.get(position).getKurulusYili());
        holder.tvUlkeBaskent.setText(itemsFiltered.get(position).getUlkeBaskent());
        holder.tvUlkeKodu.setText(itemsFiltered.get(position).getTelefonKodu());
        holder.tvUlkeAdi.setText(itemsFiltered.get(position).getUlkeAdi());
    }

    @Override
    public int getItemCount() {
        return itemsFiltered.size();
    }

    @Override
    public Filter getFilter() {

        /*
        Var olan bir list içerisinde anlık değer aramak için şöyle bir yol izledik.
        Var olan listeyi kopyala, SearchView içerisinde anlık arama esnasında, Aynı tipte üretilen
        liste içerisine aranan kelime hangi elemanda bulunuyorsa,
        kopya isminde üretilen List içerisine aranan kelimeyi taşı.
         */

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();

                List<Ulke> filtered = new ArrayList<>();

                if (query.isEmpty()) {
                    filtered = items;
                } else {
                    for (Ulke u : items) {
                        if (u.getUlkeAdi().toLowerCase().contains(query.toLowerCase())) {
                            filtered.add(u);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.count = filtered.size();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                itemsFiltered = (ArrayList<Ulke>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}