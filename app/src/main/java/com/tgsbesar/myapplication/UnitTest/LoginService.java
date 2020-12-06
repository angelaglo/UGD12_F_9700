package com.tgsbesar.myapplication.UnitTest;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.tgsbesar.myapplication.MainActivity;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;

public class LoginService {
    private FirebaseAuth firebaseAuth;

    public void login(final LoginView view, String email, String password, final
    LoginCallback callback){

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            if(firebaseAuth.getCurrentUser().isEmailVerified()){
                                callback.onSuccess(true);
                            }else{
                                callback.onError();
                                view.showLoginError("Email belum verified");
                            }
                        }else{
                            callback.onError();
                        }
                    }
                });
    }
    public Boolean getValid(final LoginView view, String email, String password){
        final Boolean[] bool = new Boolean[1];
        login(view, email, password, new LoginCallback() {
            @Override
            public void onSuccess(boolean value) {
                bool[0] = true;
            }
            @Override
            public void onError() {
                bool[0] = false;
            }
        });
        return bool[0];
    }
}

