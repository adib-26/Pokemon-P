package ElementalCreatures;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Moves {
    private String name;
    private int moveType, bp, pp, typing;
    private double acc;
    private int effect;


    public Moves(){}

    public String getName(){return this.name;}
    public int getMoveType(){return this.moveType;}
    public int getBP(){return this.bp;}
    public int getPP(){return this.pp;}
    public int getTyping(){return this.typing;}
    public double getAcc(){return this.acc;}
    public int getEffect(){return this.effect;}

    public void setName(String name){this.name = name;}
    public void setMoveType(int type){this.moveType = type;}
    public void setBP(int bp){this.bp = bp;}
    public void setPP(int pp){this.pp = pp;}
    public void setTyping(int typing){this.typing = typing;}
    public void setAcc(double acc){this.acc = acc;}
    public void setEffect(int effect){this.effect = effect;}
    public static void initializeMovesets(String file, Moves[] move){
        BufferedReader reader = null;
        String line = "";
        int i = 0;
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while((line = reader.readLine())!=null){
                String[] row = line.split(",");
                
                    move[i] = new Moves();
                    move[i].setName(row[0]);
                    move[i].setMoveType(Integer.parseInt(row[1]));
                    move[i].setBP(Integer.parseInt(row[2]));
                    move[i].setPP(Integer.parseInt(row[3]));
                    move[i].setTyping(Integer.parseInt(row[4]));
                    move[i].setAcc(Double.parseDouble(row[5]));
                    move[i].setEffect(Integer.parseInt(row[6]));
                i++;
            }
        } catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        finally{
            try{reader.close();}
            catch(IOException e){e.printStackTrace();}
        }
        for (Moves item:move){
            System.out.printf("\nMove name: %s    Move Type: %d Base Power: %d    PP: %d    Typing: %d    Acc: %.2f    Effect: %d", item.getName(), item.getMoveType(), item.getBP(), item.getPP(), item.getTyping(), item.getAcc(), item.getEffect());
        }


    }

    public static int findIndex(String moveName, Moves[] move){
        for(int i=0; i<move.length; i++){
            if (move[i].getName().equalsIgnoreCase(moveName)){return i;}
        }
        return 0;
    }







    
}

