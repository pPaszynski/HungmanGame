package com.example.dives.wisielec.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {

    private List<String> countries = Arrays.asList("Polska", "USA", "Japonia", "Portugalia");
    private List<String> cities = Arrays.asList("Warszawa", "Krakow", "Dupa", "pipppa");
    private String category;
    private String word;


    public Game(String category) {
        this.category = category;
        generateWord();
    }

    private void generateWord(){
        if (this.category.equals("Państwa")) {
            Random rand = new Random();
            this.word = countries.get(rand.nextInt(countries.size())).toUpperCase();
        } else if (this.category.equals("Miasta")) {
            Random rand = new Random();
            this.word = cities.get(rand.nextInt(cities.size())).toUpperCase();
        }
        printCategory();
        System.out.println(getWord());
    }

    public String getWord() {
        return this.word;
    }
    private void printCategory(){
        System.out.println(this.category);
    }
}
