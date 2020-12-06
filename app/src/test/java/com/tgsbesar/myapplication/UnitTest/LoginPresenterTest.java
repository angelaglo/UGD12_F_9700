package com.tgsbesar.myapplication.UnitTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock
    private LoginView view;
    @Mock
    private LoginService service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void shouldShowErrorWhenEmailIsEmpty() throws Exception {
        when(view.getEmail()).thenReturn("");
        System.out.println("email : "+view.getEmail());
        when(view.getPassword()).thenReturn("123456");
        System.out.println("password : "+view.getPassword());

        presenter.onLoginClicked();

        verify(view).showEmailError("Email Tidak Boleh Kosong");
    }
    @Test
    public void shouldShowErrorWhenPasswordIsEmpty() throws Exception{
        when(view.getEmail()).thenReturn("wahyucandra@gmail.com");
        System.out.println("email : "+view.getEmail());

        when(view.getPassword()).thenReturn("");
        System.out.println("Password : "+view.getPassword());

        presenter.onLoginClicked();

        verify(view).showPasswordError("Password Tidak Boleh Kosong");
    }

    @Test
    public void shouldShowErrorWhenEmailInvalid() throws Exception{
        when(view.getEmail()).thenReturn("wahyucandra");
        System.out.println("email : "+view.getEmail());
        when(view.getPassword()).thenReturn("123456");
        System.out.println("password : "+view.getPassword());
        presenter.onLoginClicked();

        verify(view).showEmailError("Email Tidak Valid");
    }

    @Test
    public void shouldShowErrorWhenPasswordEmailIsEmpty() throws Exception{
        when(view.getEmail()).thenReturn("");
        System.out.println("email : "+view.getEmail());

        when(view.getPassword()).thenReturn("");
        System.out.println("Password : "+view.getPassword());

        presenter.onLoginClicked();

        verify(view).showLoginError("Email dan Password tidak boleh kosong");
    }

    @Test
    public void shouldShowErrorWhenPasswordLessThanSix() throws Exception{
        when(view.getEmail()).thenReturn("wahyucandra@gmail.com");
        System.out.println("email : "+view.getEmail());
        when(view.getPassword()).thenReturn("123");
        System.out.println("password : "+view.getPassword());
        presenter.onLoginClicked();

        verify(view).showPasswordError("Password Tidak Boleh Kurang dari 6");
    }

    @Test
    public void shouldStartMainActivityWhenEmailandPasswordAreCorrect() throws Exception{
        when(view.getEmail()).thenReturn("wahyucandra@gmail.com");
        System.out.println("email : "+view.getEmail());
        when(view.getPassword()).thenReturn("123456");
        System.out.println("password : "+view.getPassword());
        when(service.getValid(view, view.getEmail(),
                view.getPassword())).thenReturn(true);
        System.out.println("Hasil : "+service.getValid(view,view.getEmail(),
                view.getPassword()));
        presenter.onLoginClicked();
    }
}