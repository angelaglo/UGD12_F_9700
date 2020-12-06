package com.tgsbesar.myapplication.UnitTest;

public class LoginPresenter {
    private LoginView view;
    private LoginService service;
    private LoginCallback callback;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public LoginPresenter(LoginView view, LoginService service) {
        this.view = view;
        this.service = service;
    }
    public void onLoginClicked() {
        if (view.getEmail().isEmpty() && view.getPassword().isEmpty()) {
            view.showLoginError("Email dan Password tidak boleh kosong");
            return;
        } else if (view.getPassword().isEmpty()) {
            view.showPasswordError("Password Tidak Boleh Kosong");
            return;
        } else if (view.getPassword().length()<6) {
            view.showPasswordError("Password Tidak Boleh Kurang dari 6");
            return;
        } else if (view.getEmail().isEmpty()) {
            view.showEmailError("Email Tidak Boleh Kosong");
            return;
        } else if (!view.getEmail().toString().trim().matches(emailPattern)) {
            view.showEmailError("Email Tidak Valid");
            return;
        } else {
            service.login(view, view.getEmail(), view.getPassword(), new
                LoginCallback() {
                    @Override
                    public void onSuccess(boolean value) {
                        view.startMainActivity();
                    }

                    @Override
                    public void onError() {
                    }
                });
            return;
        }
    }
}
