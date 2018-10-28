package com.example.dives.wisielec.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Map;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class Ranking {

    private static Ranking singleton = new Ranking( );

    //SharedPreferences sharedPreferences = View.getContext().getSharedPreferences("ranking",MODE_PRIVATE);
    //SharedPreferences.Editor editor = sharedpreferences.edit();
    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Ranking() {

    }

    /* Static 'instance' method */
    public static Ranking getInstance( ) {
        return singleton;
    }

    public void saveScore(Context context, String user, Integer score){

    }


}
