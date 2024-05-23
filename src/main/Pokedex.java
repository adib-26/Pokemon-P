package main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.ArrayList;

import entity.Pokemon;
import lib.Moves;

public class Pokedex {
    public static Pokemon[] pokedex = new Pokemon[151];
    public static Moves[] allMoves = new Moves[165];
    public static LinkedHashMap<Integer, String> typeName = new LinkedHashMap<>();
    public static LinkedHashMap<Integer, ArrayList<Integer>>typeWeakness = new LinkedHashMap<>();
    public static LinkedHashMap<Integer, ArrayList<Integer>> typeStrength = new LinkedHashMap<>();


    public static void main(String[] args) throws IOException{
        initializePokedex();
        for (Pokemon item: pokedex){
            System.out.print(item.getName() + " " + item.getType1() + " " + item.getType2() + "\n");
        }
        Moves.initializeMovesets("src\\res\\movedata.csv", allMoves);
        Pokemon.setUpMoves("src\\res\\pokemonmoveset.csv", pokedex, allMoves);
        Pokemon.setUpEvolution("src\\res\\evoline.csv", pokedex);
        setUpTypeMapping("src\\res\\typingdata.csv");

        for(int i=1; i<19; i++){
            System.out.printf("\nType %s is Weak against: \n", typeName.get(i));
            for(int w: typeWeakness.get(i)){System.out.print(typeName.get(w) + ", ");}
            System.out.printf("\nType %s is Strong against: \n", typeName.get(i));
            for(int s: typeStrength.get(i)){System.out.print(typeName.get(s) + ", ");}
        }

        for(int p=0; p<31; p++){
            System.out.print("\n");
            System.out.print(pokedex[p].getName());
            pokedex[p].showTypingDetails();
        }


    }
    
    public static Pokemon[] initializePokedex(){
        String file = "src\\res\\pokemonandtype.csv";
        BufferedReader reader = null;
        String line = "";
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            int i=0;
            final String UTF8_BOM = "\uFEFF";

            while((line = reader.readLine()) != null){
                if (line.startsWith(UTF8_BOM)){
                    line = line.substring(1);
                }
                String[] row = line.split(",");
                pokedex[i] = new Pokemon();
                
                pokedex[i].setName(row[0]);
                
                pokedex[i].setType1(Integer.parseInt(row[1]));
                
                pokedex[i].setType2(Integer.parseInt(row[2]));
                System.out.print("\n");
                i++;
            }
            
        } catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        finally{try {
            reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
}
    return pokedex;
    }

    public static void setUpTypeMapping(String file){
        String line = "";
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while((line=reader.readLine())!=null){
                String[] row = line.split(",");
                if (!(row[1].equals("null"))){
                  ArrayList<Integer> weakness = new ArrayList<>();
                  ArrayList<Integer> strength = new ArrayList<>();
                  String[] weak = row[2].split("@");
                  String[] strong = row[3].split("@");
                  for(String w:weak){weakness.add(Integer.parseInt(w));}
                  for(String s:strong){strength.add(Integer.parseInt(s));}
                  typeName.put(Integer.parseInt(row[0]), row[1]);
                  typeWeakness.put(Integer.parseInt(row[0]),weakness);
                  typeStrength.put(Integer.parseInt(row[0]), strength);
                  System.out.print("\nAdded new set in map!");
                } 
                }
            
        } catch(IOException e){e.printStackTrace();}
        finally{
            try{reader.close();}
            catch(IOException e){e.printStackTrace();}
        }

    }

  

} 

        

    
