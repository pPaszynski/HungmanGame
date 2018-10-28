package com.example.dives.wisielec.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {

    //private List<String> countries = Arrays.asList("Polska", "USA", "Japonia", "Portugalia", "Albania", );
    private List<String> countries = Arrays.asList("Albania", "Andora", "Armenia", "Austria",
            "Azerbejdżan", "Białoruś", "Belgia", "Bośnia", "Bułgaria", "Chorwacja",
            "Czarnogóra", "Czechy", "Dania", "Estonia", "Finlandia", "Francja", "Georgia",
            "Grecja", "Holandia", "Hiszpania", "Irlandia", "Islandia", "Liechtenstein", "Litwa",
            "Luksemburg", "Łotwa", "Macedonia", "Malta", "Niemcy", "Mołdawia", "Monako",
            "Norwegia", "Polska", "Rosja", "Poland", "Portugalia", "Rumunia", "Serbia",
            "Szwajcaria", "Słowacja", "Słowenia", "Szwecja", "Turcja", "Ukraina",
            "Watykan", "Węgry", "Włochy");
    private List<String> cities = Arrays.asList("Warszawa", "Lizbona", "Tirana", "Andora",
            "Wiedeń", "Bruksela", "Mińsk", "Sarajewo", "Sofia", "Podgorica", "Praga", "Kopenhaga",
            "Tallinn", "Helsinki", "Paryż", "Ateny", "Madryt", "Amsterdam", "Dublin",
            "Reykjavík", "Astana", "Vaduz", "Wilno", "Luksemburg", "Ryga", "Skopje",
            "Valletta", "Kiszyniów", "Monako", "Oslo", "Moskwa", "Bukareszt",
            "Belgrad", "Bratysława", "Kijów");
    private List<String> animals = Arrays.asList("Węgorz", "Ważka", "Bóbr", "Antylopa",
            "Rekin", "Wydra", "Pies", "Kot", "Mysz", "Jeleń", "Borsuk", "Dzięcioł",
            "Pawian", "Kapucynka", "Meduza", "Zająć", "Królik", "Chomik", "Krowa",
            "Koń", "Żyrafa", "Jesiotr", "Łania", "Słoń", "Panda", "Koala",
            "Antylopa", "Motyl", "Gepard", "Lew", "Pszczoła", "Szerszeń",
            "Żółw", "Bawół", "Niedźwiedź");
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
        } else if (this.category.equals("Zwierzęta")) {
            Random rand = new Random();
            this.word = animals.get(rand.nextInt(animals.size())).toUpperCase();
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
