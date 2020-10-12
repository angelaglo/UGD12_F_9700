package com.tgsbesar.myapplication.menu_rawatJalan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.tgsbesar.myapplication.R;

import java.util.ArrayList;

public class rawatJalan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SpesialisAdapter adapter;
    private ArrayList<Spesialis> spesialisArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rawat_jalan);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new SpesialisAdapter(spesialisArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setClick(new SpesialisAdapter.OnClickListener() {
            @Override
            public void setClick(String nama) {
                Intent intent = new Intent(rawatJalan.this, Tampil_Dokter.class);
                intent.putExtra("nama",nama);
                startActivity(intent);
            }
        });
    }

    private void addData() {
        spesialisArrayList = new ArrayList<>();
        spesialisArrayList.add(new Spesialis("Jantung"));
        spesialisArrayList.add(new Spesialis("Neurologi"));
        spesialisArrayList.add(new Spesialis("Onkologi"));
        spesialisArrayList.add(new Spesialis("Pediatris"));
        spesialisArrayList.add(new Spesialis("Kulit"));
        spesialisArrayList.add(new Spesialis("Umum"));
    }

}