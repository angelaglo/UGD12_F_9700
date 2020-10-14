package com.tgsbesar.myapplication.profile;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.database.Preferences;
import com.tgsbesar.myapplication.model.user;
import com.tgsbesar.myapplication.registerLogin.Register;
import com.tgsbesar.myapplication.splashScreen;

import static android.content.Context.MODE_PRIVATE;

public class profileFragment extends Fragment {
    private Button btn_openCam;

    //shared preference activity
    private SharedPreferences preferences;
    public static final int mode = MODE_PRIVATE;
    private String namaLengkap = "";
    private String alamat = "";
    private String noTelp = "";
    private String umur = "";
    private TextInputEditText nama_input, alamat_input, noTelp_input, umur_input;
    private RadioGroup radioGroup;
    final String KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    private int checkedIndex;

    private Button btn_save, btn_logout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Preferences preferences = new Preferences(profileFragment.this.getContext());

        //open camera for profile pict
        btn_openCam=view.findViewById(R.id.btn_image);
        btn_openCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),cameraActivity.class);
                startActivity(i);

            }
        });

        //read data from form
        nama_input=view.findViewById(R.id.input_nama);
        alamat_input=view.findViewById(R.id.input_alamat);
        noTelp_input=view.findViewById(R.id.input_telp);
        umur_input=view.findViewById(R.id.input_umur);
        btn_save=view.findViewById(R.id.btn_save);
        radioGroup = view.findViewById(R.id.radGroup);
        radioGroup.setOnCheckedChangeListener(radioGrouoOnCheckedListener);
        btn_logout =view.findViewById(R.id.btn_logout);

        //shared preference
        loadPreferences();
        setProfile();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateForm())
                {
                    return;
                }else{
                    savePreferences(KEY_SAVED_RADIO_BUTTON_INDEX, checkedIndex);
                }
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences.setKeyNorm("");
                Intent intent = new Intent(getActivity(), Register.class);
                startActivity(intent);
            }
        });

        return view;
    }

    RadioGroup.OnCheckedChangeListener radioGrouoOnCheckedListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            RadioButton checkedRadioButton = (RadioButton)radioGroup.findViewById(i);
            checkedIndex =  radioGroup.indexOfChild(checkedRadioButton);

        }
    };

    private void savePreferences(String key, int value){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.putString("namaLengkap",nama_input.getText().toString());
        editor.putString("alamat",alamat_input.getText().toString());
        editor.putString("umur",umur_input.getText().toString());
        editor.putString("noTelp",noTelp_input.getText().toString());
        editor.apply();
        editor.commit();
        Toast.makeText(getActivity(),"Profile Saved",Toast.LENGTH_SHORT).show();
    }
    private void setProfile(){

        nama_input.setText(namaLengkap);
        alamat_input.setText(alamat);
        umur_input.setText(umur);
        noTelp_input.setText(noTelp);

    }

    private void loadPreferences(){
        String name = "profile";
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        int savedRadioIndex = sharedPreferences.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
        RadioButton savedCheckedRadioButton = (RadioButton)radioGroup.getChildAt(savedRadioIndex);
        savedCheckedRadioButton.setChecked(true);

        preferences = this.getActivity().getSharedPreferences(name,mode);
        if(preferences!=null){
            namaLengkap = preferences.getString("namaLengkap","");
            alamat = preferences.getString("alamat","");
            umur= preferences.getString("umur","");
            noTelp=preferences.getString("noTelp", "");
        }
    }






    //validate profile field
    private boolean validateForm() {
        boolean result = true;

        if(TextUtils.isEmpty(nama_input.getText().toString())){
            Toast.makeText(getActivity(),"Please fill name",
                    Toast.LENGTH_SHORT).show();
            result = false;
            nama_input.setError("Name required");

        }else{
            nama_input.setError(null);
        }

        if(TextUtils.isEmpty(alamat_input.getText().toString())){
            Toast.makeText(getActivity(),"Please fill address",
                    Toast.LENGTH_SHORT).show();
            result = false;
            alamat_input.setError("Address required");

        }else{
            alamat_input.setError(null);
        }

        if(TextUtils.isEmpty(umur_input.getText().toString())){
            Toast.makeText(getActivity(),"Please fill age",
                    Toast.LENGTH_SHORT).show();
            result = false;
            umur_input.setError("Age required");
        }else{
            umur_input.setError(null);
        }

        if(TextUtils.isEmpty(noTelp_input.getText().toString())){
            Toast.makeText(getActivity(),"Please fill telp number",
                    Toast.LENGTH_SHORT).show();
            noTelp_input.setError("Number Required");
            result = false;
        }else if (noTelp_input.getText().toString().length()<10||noTelp_input.getText().toString().length()>13){
            Toast.makeText(getActivity(),"Number invalid",
                    Toast.LENGTH_SHORT).show();
            result = false;
            noTelp_input.setError("Number invalid");
        }else{
            noTelp_input.setError(null);
        }

        return result;
    }
}