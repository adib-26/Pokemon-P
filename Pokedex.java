import java.io.*;
public class Pokedex {
    static Pokemon[] pokedex = new Pokemon[151];
    static Moves[] allMoves = new Moves[165];

    public static void main(String[] args) throws IOException{
        initializePokedex();
        for (Pokemon item: pokedex){
            System.out.print(item.getName() + " " + item.getType1() + " " + item.getType2() + "\n");
        }
        initializeMoves();
        for(Moves move: allMoves){
            System.out.printf("\n%s %d %d %d %d %.2f %d", move.getName(), move.getMoveType(), move.getBP(), move.getPP(), move.getTyping(), move.getAcc(), move.getEffect());
        }
    }
    
    public static void initializePokedex(){
        String file = "pokemonandtype.csv";
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
    }

    public static void initializeMoves() throws IOException{
        String file = "movedata.csv";
        String line = "";
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String UTF8_BOM = "\uFEFF";
            int i = 0;
            while((line = reader.readLine())!=null){
                if(line.startsWith(UTF8_BOM)){line = line.substring(1);}
                String[] row = line.split(",");
                allMoves[i] = new Moves();
                allMoves[i].setName(row[0]);
                allMoves[i].setMoveType(Integer.parseInt(row[1]));
                allMoves[i].setBP(Integer.parseInt(row[2]));
                allMoves[i].setPP(Integer.parseInt(row[3]));
                allMoves[i].setTyping(Integer.parseInt(row[4]));
                allMoves[i].setAcc(Double.parseDouble(row[5]));
                allMoves[i].setEffect((Integer.parseInt(row[6])));
                i++;
            }

        }catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        finally{
            try{reader.close();}
            catch(IOException e){e.printStackTrace();}
        }
}
}
