package com.example.dives.wisielec.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dives.wisielec.R;


public class GameWindow extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.st0);

        setFontLetters();


        Intent intent = getIntent();


    }

    private void setFontLetters() {
//        char[] abc = {'a', 'ą', 'b', 'c', 'ć', 'd', 'e', 'ę',
//                'f', 'g', 'h', 'i', 'j', 'k', 'l', 'ł',
//                'm', 'n', 'ń', 'o', 'ó', 'p', 'r', 's',
//                'ś', 't', 'u', 'w', 'y', 'z', 'ź', 'ż'};
        Integer[] ids={R.id.a, R.id.ą, R.id.b, R.id.c, R.id.ć, R.id.d, R.id.e, R.id.ę,
                        R.id.f, R.id.g, R.id.h, R.id.i, R.id.j, R.id.k, R.id.l, R.id.ł,
                        R.id.m, R.id.n, R.id.ń, R.id.o, R.id.ó, R.id.p, R.id.r, R.id.s,
                        R.id.ś, R.id.t, R.id.u, R.id.w, R.id.y, R.id.z, R.id.ź, R.id.ż};

        for(Integer aa: ids)
        {
            TextView textView = (TextView) findViewById(aa);
            Typeface font = Typeface.createFromAsset(getAssets(), "fonts/mistral.ttf");
            textView.setTypeface(font);
        }
    }
}
