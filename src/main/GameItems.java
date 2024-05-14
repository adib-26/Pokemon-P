package main;
import lib.Item;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class GameItems {
    public static Item[] gameItems = new Item[141];
    public static void main(String[] args){
        BufferedReader reader = null;
        int i = 0;
        String line = "";
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("src\\res\\itemdata.csv")));
            while((line=reader.readLine())!=null){
                String[] row = line.split(",");
                gameItems[i] = new Item(i,Integer.parseInt(row[1]), row[0], row[2]);
                System.out.printf("\nItem no %d : %s, %d, %s", gameItems[i].getItemDex(), gameItems[i].getItemName(), gameItems[i].getItemType(), gameItems[i].getItemCond());
                i++;
            }
        }catch (FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        finally{try{reader.close();}
    catch(IOException e){e.printStackTrace();}}
    }
}
