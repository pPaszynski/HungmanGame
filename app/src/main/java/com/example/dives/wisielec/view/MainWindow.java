package com.example.dives.wisielec.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dives.wisielec.view.GameWindow;
import com.example.dives.wisielec.R;

public class MainWindow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_start = (Button) findViewById(R.id.button);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/mistral.ttf");
        button_start.setTypeface(font);
    }

    public void openGameWindow(View view) {
        Intent intent = new Intent(this, GameWindow.class);

        startActivity(intent);
    }
}
