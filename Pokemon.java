/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author User
 */
import java.util.LinkedList;
import java.util.Queue;
public class Pokemon {
    String name;
    int type1, type2;
    LinkedList<Pokemon> evolution;
    Queue<Moves> moves;
    
    public Pokemon(){
        this.name = null;
        this.type1 = 0;
        this.type2 = 0;
    }
    
    public String getName(){return this.name;}
    public int getType1(){return this.type1;}
    public int getType2(){return this.type2;}
    
    public void setName(String n){this.name = n;}
    public void setType1(int type){this.type1 = type;}
    public void setType2(int type){this.type2 = type;}
    public void addEvolution(Pokemon poke){evolution.addLast(poke);}
    
    
    
}
