package com.tgsbesar.myapplication.registerLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.database.DatabaseClient;
import com.tgsbesar.myapplication.database.User;

public class Register extends AppCompatActivity {

    private Button signUp, signIn;
    private TextInputLayout errorRM, errorPass;
    private FirebaseAuth firebaseAuth;
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
                    Toast.makeText(Register.this,"askdaskdsa",Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    String email = txtRM.getText().toString();
                    String password = txtPass.getText().toString();

                    firebaseAuth = FirebaseAuth.getInstance();

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        firebaseAuth.getCurrentUser().sendEmailVerification()
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                })
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if(task.isSuccessful()){
                                                            Toast.makeText(getApplicationContext(),"Register sukses, lihat email verifikasi", Toast.LENGTH_SHORT).show();
                                                            txtRM.setText("");
                                                            txtPass.setText("");
                                                        }else{
                                                            Toast.makeText(Register.this, task.getException().getMessage(),
                                                                    Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    } else{
                                        Toast.makeText(Register.this,task.getException().getMessage(),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
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
}