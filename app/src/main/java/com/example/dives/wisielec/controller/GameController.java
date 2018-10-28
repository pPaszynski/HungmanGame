package com.example.dives.wisielec.controller;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dives.wisielec.model.Game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static android.widget.Toast.LENGTH_SHORT;

public class GameController {

    private Game game;
    private String word;
    private String category;

    private static GameController singleton = new GameController( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private GameController() { }

    /* Static 'instance' method */
    public static GameController getInstance( ) {
        return singleton;
    }
    private List<String> categories = Arrays.asList("Państwa", "Miasta", "Zwierzęta");

    public GameController(String category) {
        try{
            this.game = new Game(category);
            this.word = game.getWord();
        }catch(Exception e){
            System.out.println("Game object error");
        }
    }

//    private void initiationLetters(){
//    for(TextView a : letters){
//
//    }
//}

    public List<Integer> checkLetter(String s) {
        List<Integer> positions = new ArrayList<>();

        for(Integer i = 0; i<this.word.length(); i++)
        {
            if(this.word.indexOf(s, i)!=-1){
                positions.add(this.word.indexOf(s, i));
            }
        }

        return positions;
    }

    public String getWord(){
        return this.word;
    }

    public void setCategory(String category){
        this.category=category;
        getGame();
    }

    public void getGame() {
        try{
            this.game = new Game(category);
            this.word = game.getWord();
        }catch(Exception e){
            System.out.println("Game object error");
        }
    }
    public void randomCategory(){
        Random rand = new Random();
        this.category = categories.get(rand.nextInt(categories.size()));
    }

    public String getCategory(){
        return this.category;
    }
    private void waitTo() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
