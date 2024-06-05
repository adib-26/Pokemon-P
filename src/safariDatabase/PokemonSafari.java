/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.safariDatabase;

import java.util.Scanner;

/**
 *
 * @author ikmal
 */
public class PokemonSafari {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the pokemon in your party(separate by comma and no space): ");
        String input = sc.nextLine();
        String[] list = input.split(",");

        System.out.println("You entered:");
        for (String pokemonList : list) {
            System.out.print(pokemonList + ", ");
        }
        
        SafariZone safari = new SafariZone(list);
        
        for(String pokemonInput : list){
            safari.addPokemon(pokemonInput);
        }
        
        System.out.println("\n");

        System.out.println("Sorting the pokemon follow their unique preferences...\n");

        safari.readFile();
        for(int i = 0; i < list.length; i++){
            System.out.println("Step " + (i+1) + ": " + safari.preferences[i]);
            safari.sortPokemon(list[i]);
            System.out.println("\n");
        }
    }
}
