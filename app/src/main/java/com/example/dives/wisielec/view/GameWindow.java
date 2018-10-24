package com.example.dives.wisielec.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dives.wisielec.R;
import com.example.dives.wisielec.controller.GameController;

import java.util.List;

import static android.graphics.Color.GRAY;


public class GameWindow extends Activity {

    private GameController gameController;
    private Integer[] ids;
    private Integer counter = 0;
    private String guessWord = "";
    private TextView wordTextview;
    private ImageView statImageView;
    //private TextView[] letters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        statImageView = (ImageView) findViewById(R.id.imageView2);
        setImage();
        wordTextview = (TextView)findViewById(R.id.word);

        setFontLetters();
        gameController = new GameController();
        setWordView(gameController.getWord());

        Intent intent = getIntent();


    }

    private void setFontLetters() {
//        char[] abc = {'a', 'ą', 'b', 'c', 'ć', 'd', 'e', 'ę',
//                'f', 'g', 'h', 'i', 'j', 'k', 'l', 'ł',
//                'm', 'n', 'ń', 'o', 'ó', 'p', 'r', 's',
//                'ś', 't', 'u', 'w', 'y', 'z', 'ź', 'ż'};
        ids = new Integer[]{R.id.a, R.id.ą, R.id.b, R.id.c, R.id.ć, R.id.d, R.id.e, R.id.ę,
                        R.id.f, R.id.g, R.id.h, R.id.i, R.id.j, R.id.k, R.id.l, R.id.ł,
                        R.id.m, R.id.n, R.id.ń, R.id.o, R.id.ó, R.id.p, R.id.r, R.id.s,
                        R.id.ś, R.id.t, R.id.u, R.id.w, R.id.y, R.id.z, R.id.ź, R.id.ż,
                        R.id.word};

        for(Integer aa: ids)
        {
            TextView textView = (TextView) findViewById(aa);
            Typeface font = Typeface.createFromAsset(getAssets(), "fonts/mistral.ttf");
            textView.setTypeface(font);
            //textView.setOnClickListener(onClickListener);
        }
    }

//    private View.OnClickListener onClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Integer id = v.getId();
//
//        }
//    };

    public void onClick(View view) {
        Integer id = view.getId();
        TextView letter = (TextView)findViewById(id);
        System.out.println(letter.getText().toString());
        if(gameController.checkLetter(letter.getText().toString()).isEmpty())
        {
            setImage();
        }else{
            displayLetter(gameController.checkLetter(letter.getText().toString()));
            checkWin();
            System.out.println(gameController.checkLetter(letter.getText().toString()));
        }
        letter.setTextColor(GRAY);
        letter.setEnabled(false);
        System.out.println(letter.getText().toString());
    }

    private void checkWin() {
        if(this.guessWord.indexOf("_")==-1){
            statImageView.setImageResource(R.drawable.win);
            disableKey();
        }
    }

    private void setImage() {
        switch(counter) {
            case 0:
                statImageView.setImageResource(R.drawable.st0);
                break;
            case 1:
                statImageView.setImageResource(R.drawable.st1);
                break;
            case 2:
                statImageView.setImageResource(R.drawable.st2);
                break;
            case 3:
                statImageView.setImageResource(R.drawable.st3);
                break;
            case 4:
                statImageView.setImageResource(R.drawable.st4);
                break;
            case 5:
                statImageView.setImageResource(R.drawable.st5);
                break;
            case 6:
                statImageView.setImageResource(R.drawable.st6);
                disableKey();
                break;
        }
        counter++;
        System.out.println(counter);
    }

    public void setWordView(String word) {

        for(Integer i=0; i < word.length(); i++){
            this.guessWord = guessWord+"_";
        }
        this.wordTextview.setText(guessWord.toString());
    }

    private void displayLetter(List<Integer> pos){
        StringBuilder ans = new StringBuilder(this.guessWord);
        System.out.println(pos);
        for(Integer i : pos){
            ans.setCharAt(i, gameController.getWord().charAt(i));
            //System.out.println("naaaaa"+gameController.getWord().charAt(i));
            this.guessWord=ans.toString();
           // System.out.println("geswo"+this.guessWord);
        }

        refreshWord();
    }

    private void refreshWord(){
        this.wordTextview.setText(guessWord.toString());
    }

    private void disableKey() {
//        char[] abc = {'a', 'ą', 'b', 'c', 'ć', 'd', 'e', 'ę',
//                'f', 'g', 'h', 'i', 'j', 'k', 'l', 'ł',
//                'm', 'n', 'ń', 'o', 'ó', 'p', 'r', 's',
//                'ś', 't', 'u', 'w', 'y', 'z', 'ź', 'ż'};
        wordTextview.setText(gameController.getWord());
        for(Integer aa: ids)
        {
            TextView textView = (TextView) findViewById(aa);
            textView.setEnabled(false);
            //textView.setOnClickListener(onClickListener);
        }
    }
}
