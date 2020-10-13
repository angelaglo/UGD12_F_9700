package com.tgsbesar.myapplication.menu_laboratorium;

import androidx.appcompat.app.AppCompatActivity;

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

import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.menu_rawatJalan.Dokter;
import com.tgsbesar.myapplication.menu_rawatJalan.Input;
import com.tgsbesar.myapplication.menu_rawatJalan.tampilRawatJalan;
import com.tgsbesar.myapplication.model.Laboratorium;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class laboratoriumNextActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorium_next);

        Laboratorium lab = (Laboratorium) getIntent().getSerializableExtra("Laboratorium") ;


        Calendar calendar = Calendar.getInstance();
        int Day = calendar.get(Calendar.DAY_OF_MONTH);
        int Month = calendar.get(Calendar.MONTH);
        int Year = calendar.get(Calendar.YEAR);

        Button btnDate = findViewById(R.id.buttonPickDateCheckUp);
        TextView text = findViewById(R.id.tv_dateCheckUp);
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

        AutoCompleteTextView drop = findViewById(R.id.dropdown_fill_CheckUp);
        List<String> categories = new ArrayList<String>();
        categories.add("09:00 - 11:00");
        categories.add("13:00 - 15:00");
        categories.add("17:00 - 19:00");
        categories.add("21:00 - 22:00");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, categories);
        drop.setAdapter(adapter);
        drop.setOnItemClickListener(this);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(laboratoriumNextActivity.this, tampilLaboratorium.class);
                intent.putExtra("Jam",message);
                intent.putExtra("Laboratorium",lab);
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
}