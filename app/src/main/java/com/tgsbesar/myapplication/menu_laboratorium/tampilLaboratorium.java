package com.tgsbesar.myapplication.menu_laboratorium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tgsbesar.myapplication.MainActivity;
import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.menu_rawatJalan.DaftarDokter;
import com.tgsbesar.myapplication.menu_rawatJalan.Dokter;
import com.tgsbesar.myapplication.menu_rawatJalan.DokterAdapter;
import com.tgsbesar.myapplication.model.Laboratorium;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class tampilLaboratorium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_laboratorium);

        Laboratorium lab= (Laboratorium) getIntent().getSerializableExtra("Laboratorium");
        String jam = getIntent().getStringExtra("Jam");
        String tanggal = getIntent().getStringExtra("Tanggal");

        TextView txt_PaketCheckUp = (TextView) findViewById(R.id.txtPaketCheckUp);
        TextView txt_Deskripsi = (TextView) findViewById(R.id.txtDeskripsi);
        TextView txt_harga = (TextView)findViewById(R.id.hargaPaket);
        TextView txt_tanggalCheckUp = (TextView) findViewById(R.id.txtTanggalCheckUp);
        TextView txt_jamCheckUp = (TextView) findViewById(R.id.txtJamCheckUp);

        txt_PaketCheckUp.setText(lab.kategori);
        txt_Deskripsi.setText(lab.deskripsi);
        txt_harga.setText(String.valueOf(lab.harga_test));
        txt_tanggalCheckUp.setText(tanggal);
        txt_jamCheckUp.setText(jam);

        Button btn_save = (Button)findViewById(R.id.buttonSendLab);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tampilLaboratorium.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}