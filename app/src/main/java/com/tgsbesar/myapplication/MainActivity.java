package com.tgsbesar.myapplication;
//HOME
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tgsbesar.myapplication.home.homeFragment;
import com.tgsbesar.myapplication.navigation.navigationFragment;
import com.tgsbesar.myapplication.profile.profileFragment;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {

    CardView card_rawatJalan, card_rawatInap, card_Laboratorium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // inisialisasi BottomNavigaionView
        loadFragment(new homeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);




    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.home_menu:
                fragment = new homeFragment();
                break;
            case R.id.Navigation:
                fragment = new navigationFragment();
                break;
            case R.id.account_menu:
                fragment = new profileFragment();
                break;
        }
        return loadFragment(fragment);
    }



}