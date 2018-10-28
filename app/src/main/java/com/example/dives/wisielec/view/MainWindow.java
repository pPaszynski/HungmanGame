package com.example.dives.wisielec.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dives.wisielec.controller.GameController;
import com.example.dives.wisielec.R;
import com.example.dives.wisielec.model.PrefSingleton;

public class MainWindow extends Activity {


    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    GameController gameController;
    TextView best_score;
    PrefSingleton prefSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_start = (Button) findViewById(R.id.startButton);
        this.best_score = (TextView) findViewById(R.id.bestTextView);
        Button quit_button = (Button) findViewById(R.id.quitButton);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/mistral.ttf");

        button_start.setTypeface(font);
        //best_score.setTypeface(font);
        quit_button.setTypeface(font);

        prefSingleton = PrefSingleton.getInstance();
        prefSingleton.Initialize(getApplicationContext());
        String best = prefSingleton.getInteger("best", 0)+" pkt";
        best_score.setText(best);

        setSpinner();

    }

    private void setSpinner() {
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.category_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setGravity(Gravity.CENTER);
        //((TextView) spinner.getChildAt(0).setTextColor(WHITE));
        //((TextView)findViewById(R.id.textView).setColor)
    }

    public void openGameWindow(View view) {
        Intent intent = new Intent(this, GameWindow.class);
        gameController = GameController.getInstance();
        //gameController = new GameController(spinner.getSelectedItem().toString());
        gameController.setCategory(spinner.getSelectedItem().toString());

        startActivity(intent);
    }

    public void exit(View view) {
        finish();
        System.exit(0);
    }

    @Override
    protected void onResume(){
        super.onResume();
        String best = this.prefSingleton.getInteger("best", 0)+" pkt";
        this.best_score.setText(best);
    }
}
