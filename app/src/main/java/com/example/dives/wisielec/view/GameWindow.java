package com.example.dives.wisielec.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.text.Layout;
import android.text.format.Time;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.dives.wisielec.R;
import com.example.dives.wisielec.controller.GameController;
import com.example.dives.wisielec.model.PrefSingleton;
import com.example.dives.wisielec.model.Ranking;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static android.graphics.Color.GRAY;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class GameWindow extends Activity {

    private RelativeLayout relativeLayout;
    private GameController gameController;
    private Integer[] ids;
    private Integer counter = 0, score = 0, game=0, best=0;
    private String guessWord = "";
    private TextView wordTextview, scoreTextView, categoryTextView;
    private ImageView statImageView, refreshImageViev, coverKeyImageView;
    private PrefSingleton prefSingleton;
    //private TextView[] letters;

//    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        statImageView = (ImageView) findViewById(R.id.imageView2);
        scoreTextView = (TextView) findViewById(R.id.score);
        categoryTextView = (TextView) findViewById(R.id.category);
        refreshImageViev = (ImageView) findViewById(R.id.refreshImageView);
        coverKeyImageView = (ImageView) findViewById(R.id.coverKeyimageView);

//        sharedPreferences = getSharedPreferences("ranking", Context.getApplicationContext());

        refreshImageViev.setVisibility(GONE);
        coverKeyImageView.setVisibility(GONE);
        gameController = GameController.getInstance();

        prefSingleton = PrefSingleton.getInstance();
        prefSingleton.Initialize(getApplicationContext());
        this.best = prefSingleton.getInteger("best", 0);

        setImage();
        setScore();
        setCategory(gameController.getCategory());
        wordTextview = (TextView)findViewById(R.id.word);

        setFontLetters();
        //gameController = new GameController("Państwa");
        setWordView(gameController.getWord());

        Intent intent = getIntent();


    }

    private void setScore() {
        String text = "Score: "+score;
        scoreTextView.setText(text);
    }

    private void setCategory(String category){
        String text = "Kategoria: "+category;
        categoryTextView.setText(text);
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
            textView.setTextColor(WHITE);
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
        letter.setTextColor(GRAY);
        letter.setEnabled(false);
        if(gameController.checkLetter(letter.getText().toString()).isEmpty())
        {
            setImage();
        }else{
            displayLetter(gameController.checkLetter(letter.getText().toString()));
            checkWin();
            }
    }

    private void checkWin() {
        if(this.guessWord.indexOf("_")==-1){
            this.game=1;
            this.statImageView.setImageResource(R.drawable.win);
            this.wordTextview.setText(gameController.getWord());
            this.score = this.score + gameController.getWord().length();
            setScore();
            disableKey();
            this.refreshImageViev.setVisibility(VISIBLE);
            this.coverKeyImageView.setVisibility(VISIBLE);
        }
    }

    private void refreshGame() {
        this.gameController.randomCategory();
        setCategory(this.gameController.getCategory());
        this.gameController.getGame();
        this.counter=0;
        this.game=0;
        this.guessWord="";
        this.refreshImageViev.setVisibility(GONE);
        this.coverKeyImageView.setVisibility(GONE);
        setImage();
        setWordView(this.gameController.getWord());
        refreshLetters();
    }

    private void refreshLetters(){
        for(Integer aa: ids)
        {
            TextView textView = (TextView) findViewById(aa);
            textView.setEnabled(true);
            textView.setTextColor(WHITE);
            //textView.setOnClickListener(onClickListener);
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
                wordTextview.setTextColor(RED);
                disableKey();
                refreshImageViev.setVisibility(VISIBLE);
                coverKeyImageView.setVisibility(VISIBLE);
                checkRecords();
                break;
        }
        counter++;
        System.out.println(counter);
    }

    private void checkRecords() {
        if(this.score > this.best){
            this.best = this.score;
            prefSingleton.putInteger("best", this.best);
        }
    }

    public Integer getBest(){
        return this.best;
    }

    public void setWordView(String word) {

        System.out.println(word);
        for(Integer i=0; i < word.length(); i++){
            this.guessWord = guessWord+"_";
        }
        this.wordTextview.setText(guessWord);
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
        this.wordTextview.setText(this.guessWord);
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
            //textView.setVisibility(View.GONE);
            //textView.setOnClickListener(onClickListener);
        }
    }

    public void endAction(View view) {
        if(this.game==1){
            refreshGame();
        }else{
            System.out.println("dupppppa");
            finish();
//            Intent intent = new Intent(this, MainWindow.class);
//            startActivity(intent);
        }
    }
}
