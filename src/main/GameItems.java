package src.main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import src.lib.Item;

public class GameItems {
    public static Item[] gameItems = new Item[136];

    public GameItems() {
        displayItem();
    }

    public void displayItem() {
        BufferedReader reader = null;
        int i = 0;
        String line = "";
        try{
            reader = new BufferedReader(new FileReader(new File("res/itemdata.csv")));
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
