/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package src.safariDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ikmal
 */
public class SafariZone {

    LinkedList<String> pokemonSafari;
    String[] pokemonList;
    String[] preferences;

    public SafariZone(String[] list) {
        pokemonSafari = new LinkedList<>();
        this.pokemonList = list;
        this.preferences = new String[list.length];
    }

    public void readFile() {
        String file = "res/gen01.csv";
        String line = "";
//        for (int i = 0; i < pokemonList.length; i++) {
//            addPokemon(pokemonList[i]);
//        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (int i = 0; i < pokemonList.length; i++) {

                    if (pokemonList[i].trim().equalsIgnoreCase(row[0].trim())) {
                        preferences[i] = row[3];
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException ex) {
            Logger.getLogger(SafariZone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addPokemon(String pokemonInput) {
        pokemonSafari.add(pokemonInput);
    }

    public void sortPokemon(String pokemonName) {

        // Eevee insists on being positioned either at the beginning of the lineup
        if ("Eevee".equalsIgnoreCase(pokemonName)) {
            pokemonSafari.remove("Eevee");
            pokemonSafari.addFirst("Eevee");
            System.out.println("Sorted Pokemon: " + pokemonSafari.toString());
        } // Pikachu demands to be placed at the center of the arrangement
        else if ("Pikachu".equalsIgnoreCase(pokemonName)) {
            pokemonSafari.remove("Pikachu");
            pokemonSafari.add(pokemonSafari.size() / 2, "Pikachu");
            System.out.println("Sorted Pokemon: " + pokemonSafari.toString());
        } // Snorlax insists on being positioned at the end of the lineup
        else if ("Snorlax".equalsIgnoreCase(pokemonName)) {
            pokemonSafari.remove("Snorlax");
            pokemonSafari.addLast("Snorlax");
            System.out.println("Sorted Pokemon: " + pokemonSafari.toString());
        } // Bulbasaur refuses to be placed next to Charmander
        else if ("Bulbasaur".equalsIgnoreCase(pokemonName) && "Charmander".equalsIgnoreCase(pokemonName)) {
            pokemonSafari.remove("Charmander");
            pokemonSafari.remove("Bulbasaur");
            pokemonSafari.addLast("Charmander");
            pokemonSafari.addFirst("Bulbasaur");
            System.out.println("Sorted Pokemon: " + pokemonSafari.toString());
        } // Jigglypuff prefers to be surrounded by other "cute" Pokémon
        else if ("Jigglypuff".equalsIgnoreCase(pokemonName)) {
            int pikachuIndex = pokemonSafari.indexOf("Pikachu");
            if (pikachuIndex != -1) {
                pokemonSafari.remove("Jigglypuff");
                pokemonSafari.add(pikachuIndex, "Jigglypuff");
                System.out.println("Sorted Pokemon: " + pokemonSafari.toString());
            }
        } // Machop demands to be placed next to the heaviest Pokemon
        else if ("Machop".equalsIgnoreCase(pokemonName)) {
            int snorlaxIndex = pokemonSafari.indexOf("Snorlax");
            if (snorlaxIndex != -1) {
                pokemonSafari.remove("Machop");
                pokemonSafari.add(snorlaxIndex, "Machop");
                System.out.println("Sorted Pokemon: " + pokemonSafari.toString());
            }
        } else{
            System.out.println("Sorted Pokemon: " + pokemonSafari.toString());
        }

    }
}
