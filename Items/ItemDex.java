package Items;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class ItemDex {
    static ArrayList<Item> itemDex = new ArrayList<>();

    public static void main(String[] args) {
        initializeItemDex();
    }

    public static void initializeItemDex(){
        String file = "itemdata.csv";
        BufferedReader reader = null;
        String line = "";
        String UTF8_BOM = "\uFEFF";
        int i = 0;
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while((line = reader.readLine())!=null){
                if(line.startsWith(UTF8_BOM)){line=line.substring(1);}
                String[] row = line.split(",");
                System.out.printf("\nItem name: %s    Item Type: %d    Item Use: %d", row[0], row[1], row[2]);


            }}catch (FileNotFoundException e){e.printStackTrace();}
            catch (IOException e){e.printStackTrace();}
            finally{
                try{reader.close();}
                catch(IOException e){e.printStackTrace();}
            }
        

    }
    
}
