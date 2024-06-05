package src.kanto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KantoData {
    private Map<String, String> gyms = new HashMap<>(); 

    public KantoData() {
        generateGymData();
    }

    public void generateGymData() {
        gyms.put("Pewter City", "Brock - Rock type");
        gyms.put("Saffron City", "Sabrina - Psychic");
        gyms.put("Vermilion City", "Lt.Surge - Electric");
        gyms.put("Viridian City", "Giovanni - Earth");
        gyms.put("Celadon City", "Erika - Grass");
        gyms.put("Cerulean City", "Misty - Water");
        gyms.put("Cinnabar City", "Blaine - Fire");
        gyms.put("Fuschia City", "Koga - Poison");
    }

    public void displayMap(String fileName, String currTrainerLoc) {
        FileReader fr = null;

        try {
            fr = new FileReader(new File("res/"+fileName+".txt")); 
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(fr);
        try {
            String line;
            while((line = br.readLine()) != null) {
                if(line.contains(currTrainerLoc)) {
                    String selected = "**"+currTrainerLoc+"**";
                    String replacedLine = line.replace(currTrainerLoc, selected);
                    System.out.println(replacedLine);
                } else {
                    System.out.println("    " +line);
                }
            }
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getGymData() {
        return gyms;
    }
}
