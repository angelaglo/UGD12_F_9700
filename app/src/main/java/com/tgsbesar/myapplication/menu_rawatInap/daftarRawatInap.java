package com.tgsbesar.myapplication.menu_rawatInap;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.databinding.ActivityDaftarRawatInapBinding;
import com.tgsbesar.myapplication.model.KelasKamar;

import java.util.ArrayList;

public class daftarRawatInap extends AppCompatActivity {

    private ArrayList<KelasKamar> listKamar;
    private RecyclerView recyclerView;
    private CardView card_clicked;
    private recyclerViewDaftarInap adapter;
    private static ActivityDaftarRawatInapBinding binding;
    private String tipe_kamar;
    private TextView tv_tipeKamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_daftar_rawat_inap);

        //get data mahasiswa
        listKamar = new daftarKelasKamar().KELAS_KAMAR;

        //recycler view
        RecyclerView recyclerView = binding.recyclerViewRawatInap;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new recyclerViewDaftarInap(listKamar);
        recyclerView.setAdapter(adapter);




    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }


}