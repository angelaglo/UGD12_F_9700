package com.tgsbesar.myapplication.UnitTest;

import com.tgsbesar.myapplication.database.User;

public interface LoginView {
    String getEmail();
    void showEmailError(String message);
    String getPassword();
    void showPasswordError(String message);
    void showEmailPasswordError(String message);
    void startMainActivity();
    void startUserProfileActivity(User user);
    void showLoginError(String message);
    void showErrorResponse(String message);
}
