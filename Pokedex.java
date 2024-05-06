import java.io.*;
public class Pokedex {
    static Pokemon[] pokedex = new Pokemon[151];
    public static void main(String[] args){
        initializePokedex();
        for (Pokemon item: pokedex){
            System.out.print(item.getName() + " " + item.getType1() + " " + item.getType2() + "\n");
        }
    }
    
    public static void initializePokedex(){
        String file = "pokemonandtype.csv";
        BufferedReader reader = null;
        String line = "";
        try{
            reader = new BufferedReader(new FileReader(file));
            int i=0;

            while((line = reader.readLine()) != null){
                
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
    }
    
}
