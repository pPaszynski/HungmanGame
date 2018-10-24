package com.example.dives.wisielec.controller;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dives.wisielec.model.Game;


import java.util.Arrays;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class GameController {

    private Game game;
    private String word;
    private List<String> categories = Arrays.asList("Państwa", "Miasta");

    public GameController() {
        try{
            this.game = new Game("Państwa");
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

    public void checkLetter(String s) {

    }

    public String getWord(){
        return this.word;
    }
}
