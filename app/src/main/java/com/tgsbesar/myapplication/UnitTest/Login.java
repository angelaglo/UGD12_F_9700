package com.tgsbesar.myapplication.UnitTest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.tgsbesar.myapplication.MainActivity;
import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.database.User;
import com.tgsbesar.myapplication.registerLogin.Register;

import static android.widget.Toast.LENGTH_SHORT;

public class Login extends AppCompatActivity implements LoginView{

    private TextInputEditText txtRMLogin, txtPassLogin;
    private TextInputLayout errorRMLog, errorPassLog;
    private TextView registernext;
    private Button login;
    public static final String NORM = "norm";
    private FirebaseAuth firebaseAuth;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this, new LoginService());
        txtRMLogin = findViewById(R.id.tv_rmLogin);
        txtPassLogin = findViewById(R.id.tv_passLogin);

        errorRMLog = findViewById(R.id.layout_rmLogin);
        errorPassLog = findViewById(R.id.layout_passLogin);

        login = findViewById(R.id.signIn);

        registernext = findViewById(R.id.toRegister);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onLoginClicked();
            }
        });

        registernext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
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

    @Override
    public String getEmail() {
        return txtRMLogin.getText().toString();
    }

    @Override
    public void showEmailError(String message) {
        txtRMLogin.setError(message);
    }

    @Override
    public String getPassword() {
        return txtPassLogin.getText().toString();
    }

    @Override
    public void showPasswordError(String message) {
        txtPassLogin.setError(message);
    }

    @Override
    public void showEmailPasswordError(String message) {

    }

    @Override
    public void startMainActivity() {
        new ActivityUtil(this).startMainActivity();
    }

    @Override
    public void startUserProfileActivity(User user) {

    }

    @Override
    public void showLoginError(String message) {
        Toast.makeText(this, message, LENGTH_SHORT).show();
    }

    @Override
    public void showErrorResponse(String message) {
        Toast.makeText(this, message, LENGTH_SHORT).show();
    }
}