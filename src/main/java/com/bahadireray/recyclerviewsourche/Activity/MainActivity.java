package com.bahadireray.recyclerviewsourche.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.bahadireray.recyclerviewsourche.Adapter.UlkeAdapter;
import com.bahadireray.recyclerviewsourche.Model.Ulke;
import com.bahadireray.recyclerviewsourche.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchView;
    RecyclerView recyclerView;
    UlkeAdapter adapter;
    List<Ulke> ulkeler;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe);
        recyclerView = findViewById(R.id.recyclerView);
        ulkeler = new ArrayList<>();
        //String ulkeAdi, String ulkeResimUrl, String telefonKodu, String ulkeBaskent, int kurulusYili

        ulkeler.add(new Ulke("Spain", getString(R.string.turkiyem), "+34", "Madrid", 1469));
        ulkeler.add(new Ulke("Greece", getString(R.string.turkiyem), "+30", "Atina", 1821));
        ulkeler.add(new Ulke("Türkiye", getString(R.string.turkiyem), "+90", "Ankara", 1923));
        ulkeler.add(new Ulke("Egypt", getString(R.string.turkiyem), "+20", "Kahire", 3150));
        ulkeler.add(new Ulke("Liberia", getString(R.string.turkiyem), "+231", "Monrovia", 1822));
        ulkeler.add(new Ulke("South Korea", getString(R.string.turkiyem), "+82", "Seul", 1948));
        ulkeler.add(new Ulke("Spain", getString(R.string.turkiyem), "+34", "Madrid", 1469));
        ulkeler.add(new Ulke("Greece", getString(R.string.turkiyem), "+30", "Atina", 1821));
        ulkeler.add(new Ulke("Türkiye", getString(R.string.turkiyem), "+90", "Ankara", 1923));
        ulkeler.add(new Ulke("Egypt", getString(R.string.turkiyem), "+20", "Kahire", 3150));
        ulkeler.add(new Ulke("Liberia", getString(R.string.turkiyem), "+231", "Monrovia", 1822));
        ulkeler.add(new Ulke("South Korea", getString(R.string.turkiyem), "+82", "Seul", 1948));


        adapter = new UlkeAdapter(ulkeler, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "yenilendi", Toast.LENGTH_LONG).show();
                        swipeRefreshLayout.setRefreshing(true);
                        Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(refresh);
                        finish();


                    }
                }, 2000);
            }
        });

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_orange_dark), getResources().getColor(android.R.color.holo_purple), getResources().getColor(android.R.color.holo_blue_light));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_aramam);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        //Toast.makeText(getApplicationContext(),query,Toast.LENGTH_LONG).show();
        adapter.getFilter().filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
}