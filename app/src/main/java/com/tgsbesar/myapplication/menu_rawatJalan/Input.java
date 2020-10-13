package com.tgsbesar.myapplication.menu_rawatJalan;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tgsbesar.myapplication.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Input extends AppCompatActivity  implements AdapterView.OnItemClickListener {


    String message, no_urut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Dokter dtr = (Dokter) getIntent().getSerializableExtra("Dokter"); //1

        Calendar calendar = Calendar.getInstance();
        int Day = calendar.get(Calendar.DAY_OF_MONTH);
        int Month = calendar.get(Calendar.MONTH);
        int Year = calendar.get(Calendar.YEAR);

        Button btnDate = findViewById(R.id.buttonPickDate);
        TextView text = findViewById(R.id.tv_date);
        Button btnSend = findViewById(R.id.buttonSend);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        String strDate = dayOfMonth + "/" + (monthOfYear+1) + "/" + year;
                        text.setText(strDate);
                    }
                },Year, Month, Day);

                dialog.show(getFragmentManager(),"DatePickerDialog");
            }
        });

        AutoCompleteTextView drop = findViewById(R.id.dropdown_fill);
        List<String> categories = new ArrayList<String>();
        categories.add("09:00 - 11:00");
        categories.add("13:00 - 15:00");
        categories.add("17:00 - 19:00");
        categories.add("21:00 - 22:00");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, categories);
        drop.setAdapter(adapter);
        drop.setOnItemClickListener(this);
        no_urut=String.valueOf(getRandomNumberInRange(1,100));

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Input.this, tampilRawatJalan.class);
                intent.putExtra("Jam",message);
                intent.putExtra("Dokter",dtr);
                intent.putExtra("no_urut",no_urut);
                intent.putExtra("Tanggal",text.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        message = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), "Jam " + message, Toast.LENGTH_SHORT).show();
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
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}