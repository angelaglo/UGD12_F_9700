package com.tgsbesar.myapplication;
//HOME
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView card_rawatJalan, card_rawatInap, card_Laboratorium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pilihan layanan
        card_rawatJalan=findViewById(R.id.card_rawatJalan);
        card_rawatInap=findViewById(R.id.card_rawatInap);
        card_Laboratorium=findViewById(R.id.card_laboratorium);

        card_rawatJalan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, rawatJalan.class);
                startActivity(i);
            }
        });

        card_rawatInap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, rawatInap.class);
                startActivity(i);
            }
        });

        card_Laboratorium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, laboratorium.class);
                startActivity(i);
            }
        });
    }
}