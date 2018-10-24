package com.example.dives.wisielec;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

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
