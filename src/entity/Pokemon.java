package src.entity;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
/**
 *
 * @author User
 */
import java.util.LinkedList;
import java.util.PriorityQueue;

import src.lib.Moves;
import src.lib.Evolution;
import src.lib.LearnableMoves;
import src.main.Pokedex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Pokemon {
    String name;
    int type1, type2;
    LinkedList<Evolution> evolution = new LinkedList<>();
    PriorityQueue<LearnableMoves> movesets = new PriorityQueue<>();
    
    public Pokemon(){
        this.name = null;
        this.type1 = 0;
        this.type2 = 0;
    }
    
    public String getName(){return this.name;}
    public int getType1(){return this.type1;}
    public int getType2(){return this.type2;}
    public static int getDexNo(String name, Pokemon[] pokedex){
        for(int i = 0; i<pokedex.length; i++){
            if (name.equals(pokedex[i].getName())){return (i+1);}
        }
        return -1;
    }
    
    public void setName(String n){this.name = n;}
    public void setType1(int type){this.type1 = type;}
    public void setType2(int type){this.type2 = type;}
    public void showTypingDetails(){
        System.out.printf("\nThis Pokemon is Weak against: \n");
        for (int i=0; i<Pokedex.typeWeakness.get(this.type1).size(); i++){System.out.print(Pokedex.typeName.get(Pokedex.typeWeakness.get(type1).get(i)) + ", ");}
        if (this.type2!=0){for(int i=0; i<Pokedex.typeWeakness.get(this.type2).size(); i++){System.out.print(Pokedex.typeName.get(Pokedex.typeWeakness.get(type2).get(i)) + ", ");}}
        System.out.printf("\nThis Pokemon is Strong against: \n");
        for(int i=0; i<Pokedex.typeStrength.get(this.type1).size(); i++){System.out.print(Pokedex.typeName.get(Pokedex.typeStrength.get(type1).get(i)) + ", ");}
        if(this.type2!=0){for(int i=0;i<Pokedex.typeStrength.get(this.type2).size(); i++){System.out.print(Pokedex.typeName.get(Pokedex.typeStrength.get(type2).get(i)) + ", ");}}
    }
    public ArrayList<Integer> getTypeWeakness(){
        ArrayList<Integer> typeWeakness = new ArrayList<>();
        for (int one: Pokedex.typeWeakness.get(this.type1)){typeWeakness.add(one);}
        for (int two: Pokedex.typeWeakness.get(this.type2)){typeWeakness.add(two);}
        return typeWeakness;
    }
    public ArrayList<Integer> getTypeAdvantage(){
        ArrayList<Integer> typeAdvantage = new ArrayList<>();
        for (int one: Pokedex.typeStrength.get(this.type1)){typeAdvantage.add(one);}
        for (int two: Pokedex.typeStrength.get(this.type2)){typeAdvantage.add(two);}
        return typeAdvantage;
    }
    public LinkedList<Evolution> getEvolutions(){return this.evolution;}
    public PriorityQueue<LearnableMoves> getMovesets(){return this.movesets;}
    
    public static void setUpMoves(String file, Pokemon[] pokedex, Moves[] allMoves){
        String line = "";
        BufferedReader reader = null;
        int i = 0;
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while((line=reader.readLine())!=null){
                line = line.replace("\"", "");
                String[] row = line.split(",");
                for(int j=0;j<(row.length/2);j++){
                    Moves add = allMoves[Moves.findIndex(row[j], allMoves)];
                    int lvl = Integer.parseInt(row[row.length/2 + j]);
                    pokedex[i].getMovesets().offer(new LearnableMoves(add, lvl));
                }
                System.out.printf("\nMoves that can be learned by %s is : %s at Lvl %d\n", pokedex[i].getName(), pokedex[i].getMovesets().peek().getMove().getName(), pokedex[i].getMovesets().peek().getLevel());
                i++;  
            }
        }catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        finally{try{
            reader.close();
        }catch(IOException e){e.printStackTrace();}}
        for (Pokemon item:pokedex){
        System.out.printf("\nFirst move to learnt by %s : %s at level %d ", item.getName(), item.getMovesets().peek().getMove().getName(), item.getMovesets().peek().getLevel());
        }
    }

    public static void setUpEvolution(String file, Pokemon[] pokedex){
        BufferedReader reader = null;
        String line = "";
        int i = 0;
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while((line=reader.readLine())!=null){
                line = line.replace("\"", "");

                String[] row = line.split(",");
                for (int j=0; j<row.length/3; j++){
                    if(row[0].equals("null")){break;}
                    Pokemon toEvolve = pokedex[Integer.parseInt(row[j])-1];
                    int evoType = Integer.parseInt(row[row.length/3 + j]);
                    int evoCond = Integer.parseInt(row[row.length/3 * 2 + j]);
                    System.out.printf("\n%s evolves into %s with evo type %d and cond %d\n", pokedex[i].getName(), toEvolve.getName(), evoType, evoCond);
                    pokedex[i].getEvolutions().addLast(new Evolution(toEvolve, evoType, evoCond));
                }
                i++;

                


            }
            
        }catch(FileNotFoundException e){e.printStackTrace();}
            catch(IOException e){e.printStackTrace();}
            finally{try{reader.close();}
        catch(IOException e){e.printStackTrace();}}
        
    }


    
    
}
