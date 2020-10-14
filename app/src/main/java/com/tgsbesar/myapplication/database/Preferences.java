package com.tgsbesar.myapplication.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    private static final String KEY_NORM = "noRM";
    private static final String SHARED_PREF = "PREF_SHARED";
    private Context context;
    private SharedPreferences shared;

    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public Preferences(Context context){
        this.context=context;
        this.shared = this.context.getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE);
    }

    public Boolean getKeyNorm(){
        return getSharedPreference(context).getBoolean(KEY_NORM,false);
    }

    public void setKeyNorm(String noRM, boolean b){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(KEY_NORM,false);
        editor.apply();
    }

}
