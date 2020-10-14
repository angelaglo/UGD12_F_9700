package com.tgsbesar.myapplication.registerLogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tgsbesar.myapplication.MainActivity;
import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.database.AppDatabase;
import com.tgsbesar.myapplication.database.DatabaseClient;
import com.tgsbesar.myapplication.database.Preferences;
import com.tgsbesar.myapplication.database.User;
import com.tgsbesar.myapplication.home.homeFragment;

public class Login extends AppCompatActivity {

    private TextInputEditText txtRMLogin, txtPassLogin;
    private TextInputLayout errorRMLog, errorPassLog;
    private TextView registernext;
    private Button login;
    public static final String NORM = "norm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtRMLogin = findViewById(R.id.tv_rmLogin);
        txtPassLogin = findViewById(R.id.tv_passLogin);

        errorRMLog = findViewById(R.id.layout_rmLogin);
        errorPassLog = findViewById(R.id.layout_passLogin);

        login = findViewById(R.id.signIn);

        registernext = findViewById(R.id.toRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateForm())
                {
                    return;
                }else{
                    userLogin();
                }
            }
        });

        registernext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateForm() {
        boolean result = true;

        if(TextUtils.isEmpty(txtRMLogin.getText().toString())){
            result = false;
            txtRMLogin.setError("Nomor rekam medis harus diisi");

        }else{
            txtRMLogin.setError(null);
        }

        if(TextUtils.isEmpty(txtPassLogin.getText().toString())){
            result = false;
            txtPassLogin.setError("Password harus diisi");

        }else{
            txtPassLogin.setError(null);
        }

        return result;
    }

    private void userLogin() {
        final String noRMLogin = txtRMLogin.getText().toString();
        final String passLogin = txtPassLogin.getText().toString();

        class UserLogin extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {
                User user = DatabaseClient.getInstance(getApplicationContext())
                        .getDatabaseUser()
                        .userDao()
                        .login(noRMLogin,passLogin);
                return user;
            }

            @Override
            protected void onPostExecute(User user){
                super.onPostExecute(user);

                if(user == null){
                    Toast.makeText(getApplicationContext(),"No rekam medis / password salah", Toast.LENGTH_SHORT).show();
                }
                else{
                    Preferences preferences = new Preferences(Login.this.getApplicationContext());
                    preferences.setKeyNorm(user.getNoRM());
                    Toast.makeText(getApplicationContext(),"Selamat datang, "+noRMLogin, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    intent.putExtra("norekam",user.getNoRM());
                    startActivity(intent);
                }
            }
        }

        UserLogin log = new UserLogin();
        log.execute();
    }


}