package com.tgsbesar.myapplication.menu_rawatJalan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tgsbesar.myapplication.MainActivity;
import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.menu_laboratorium.tampilLaboratorium;

public class tampilRawatJalan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_rawat_jalan);

        Dokter dtr = (Dokter) getIntent().getSerializableExtra("Dokter");
        String jam = getIntent().getStringExtra("Jam");
        String tanggal = getIntent().getStringExtra("Tanggal");

        TextView txt_spesialis = (TextView) findViewById(R.id.txtSpesialis);
        TextView txt_dokter = (TextView) findViewById(R.id.txtDokter);
        TextView txt_tanggal = (TextView) findViewById(R.id.txtTanggal);
        TextView txt_jam = (TextView) findViewById(R.id.txtJam);

        txt_spesialis.setText(dtr.jabatan);
        txt_dokter.setText(dtr.nama);
        txt_tanggal.setText(tanggal);
        txt_jam.setText(jam);

        Button btn_save = (Button)findViewById(R.id.buttonSendRJ);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tampilRawatJalan.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}