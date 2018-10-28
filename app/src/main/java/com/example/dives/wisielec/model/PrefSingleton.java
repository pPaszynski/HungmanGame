package com.example.dives.wisielec.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefSingleton {
    private static PrefSingleton mInstance;
    private Context mContext;
    //
    private SharedPreferences mMyPreferences;
    private SharedPreferences.Editor editor;

    private PrefSingleton(){ }

    public static PrefSingleton getInstance(){
        if (mInstance == null) mInstance = new PrefSingleton();
        return mInstance;
    }

    public void Initialize(Context ctxt){
        mContext = ctxt;
        //
        mMyPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        editor = mMyPreferences.edit();
    }

    public void putInteger(String name, Integer value){
        editor.putInt(name, value);
        editor.commit();
    }

    public Integer getInteger(String name, Integer val){
        return mMyPreferences.getInt(name, val);
    }

}
