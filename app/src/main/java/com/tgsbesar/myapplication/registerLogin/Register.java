package com.tgsbesar.myapplication.registerLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.database.DatabaseClient;
import com.tgsbesar.myapplication.database.User;

public class Register extends AppCompatActivity {

    private Button signUp, signIn;
    private TextInputLayout errorRM, errorPass;
    private TextInputEditText txtRM, txtPass;
    private TextView loginNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signUp = findViewById(R.id.signUp);

        txtRM = findViewById(R.id.tv_rm);
        txtPass = findViewById(R.id.tv_pass);
        errorRM = findViewById(R.id.layout_rm);
        errorPass = findViewById(R.id.layout_pass);

        loginNext = findViewById(R.id.toLogin);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateForm())
                {
                    return;
                }else{
                    addUser();
                }
            }
        });

        loginNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateForm() {
        boolean result = true;

        if(TextUtils.isEmpty(txtRM.getText().toString())){
            result = false;
            txtRM.setError("Nomor rekam medis harus diisi");

        }else{
            txtRM.setError(null);
        }

        if(TextUtils.isEmpty(txtPass.getText().toString())){
            result = false;
            txtPass.setError("Password harus diisi");

        }else{
            txtPass.setError(null);
        }

        return result;
    }


    private void addUser() {
        final String noRM = txtRM.getText().toString();
        final String password = txtPass.getText().toString();

        class AddUser extends AsyncTask<Void, Void, Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User();
                user.setNoRM(noRM);
                user.setPassword(password);

                DatabaseClient.getInstance(getApplicationContext()).getDatabaseUser()
                        .userDao()
                        .insert(user);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "User saved, login please.", Toast.LENGTH_SHORT).show();
                txtRM.setText("");
                txtPass.setText("");
            }
        }

        AddUser add = new AddUser();
        add.execute();
    }
}