package com.tgsbesar.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.database.Preferences;
import com.tgsbesar.myapplication.registerLogin.Login;
import com.tgsbesar.myapplication.registerLogin.Register;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Preferences preferences = new Preferences(splashScreen.this.getApplicationContext());
        if(preferences.getKeyNorm() == false){
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
            finish();
        }
        else if(preferences.getKeyNorm() == true){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}