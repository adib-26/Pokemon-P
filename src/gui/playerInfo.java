package src.gui;

import java.util.LinkedList;

public class playerInfo {

    private static String name,level,location;

    LinkedList pokemon = new LinkedList<String>();
    playerInfo(){}

    public void setPlayerName(String name){
        this.name = name;
    }
    public String getPlayerName(){
        return name;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }
    public void setPlayerPokemon(LinkedList pokemon){
        for(Object poke:pokemon){
        }
    }

    public String getplauerPokemon(){
       return name;
    }


}
