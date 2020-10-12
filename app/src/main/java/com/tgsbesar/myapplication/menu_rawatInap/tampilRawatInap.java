package com.tgsbesar.myapplication.menu_rawatInap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tgsbesar.myapplication.MainActivity;
import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.menu_laboratorium.tampilLaboratorium;
import com.tgsbesar.myapplication.menu_rawatJalan.Dokter;
import com.tgsbesar.myapplication.model.KelasKamar;

public class tampilRawatInap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_rawat_inap);

        KelasKamar kmr = (KelasKamar) getIntent().getSerializableExtra("KelasKamar");
        String tanggal = getIntent().getStringExtra("Tanggal");

        TextView txt_TipeKamar = (TextView) findViewById(R.id.txtKelasKamar);
        TextView txt_Fasilitas = (TextView) findViewById(R.id.txtFasilitas);
        TextView txt_Harga = (TextView)findViewById(R.id.txtHarga) ;
        TextView txt_tanggal = (TextView) findViewById(R.id.txtTanggal);


        txt_TipeKamar.setText(kmr.tipe_kamar);
        txt_Fasilitas.setText(kmr.fasilitas_kamar);
        txt_Harga.setText(String.valueOf(kmr.harga_kamar));
        txt_tanggal.setText(tanggal);

        Button btn_save = (Button)findViewById(R.id.buttonSendRI);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tampilRawatInap.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}