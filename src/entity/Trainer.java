package entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import main.Pokedex;

public class Trainer {
    String name;
    String currentLocation;
    ArrayList<TrainerPokemon> pokemonTeam;
    List<String> badges;
    

    public Trainer(String name) {
        this.name = name;
        this.currentLocation = "Pallet Town";
        this.pokemonTeam = new ArrayList<>();
        this.badges = new ArrayList<>();
    }

    public Trainer(String name, String currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.pokemonTeam = new ArrayList<>();
        this.badges = new ArrayList<>();
    }

    public Trainer(String name, String currentLocation, ArrayList<TrainerPokemon> pokemonTeam) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.pokemonTeam = pokemonTeam;
        this.badges = new ArrayList<>();
    }

    public Trainer(String name, String currentLocation, ArrayList<TrainerPokemon> pokemonTeam, List<String> badges) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.pokemonTeam = pokemonTeam;
        this.badges = badges;
    }

    public void addPokemon(Pokemon pokemon, int level, String status) {
        if(partyIsFull()) {
            System.out.println("You can only carry 6 pokemon at a time");
            return;
        }
        TrainerPokemon newMember = new TrainerPokemon(main.Pokedex.pokedex, pokemon.getName(), level, status);
        pokemonTeam.add(newMember);
    }

    public ArrayList<TrainerPokemon> getAllPokemon(){return this.pokemonTeam;}

    public boolean addBadges(String badges) {
        if(badgesIsFull()) {
            System.out.println("You have collected all badges. Rematch with a gym leader won't give additional badges");
            return true;
        }
        return false;
    }

    public boolean badgesIsFull() {
        if(badges.size() >= 8) {
            return true;
        }
        return false;
    }

    public boolean partyIsFull() {
        if(pokemonTeam.size() >= 6) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void displayPokemon() {
        System.out.println("Pokemon: " + pokemonTeam.toString());
    }

    public void displayBadges() {
        System.out.println("Pokemon: " + badges.toString());
    }

}
