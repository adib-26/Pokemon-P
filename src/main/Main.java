package src.main;

import java.util.Scanner;

import src.entity.Trainer;
import src.kanto.KantoData;
import src.kanto.KantoMap;
import src.kanto.RivalRace;

public class Main {
    public static void main(String[] args) {
        KantoMap kantoMap = new KantoMap();
        KantoData kantoData = new KantoData();
        Trainer trainer = new Trainer("Ash");
        Scanner scanner = new Scanner(System.in);
        String trainerCurrLoc = trainer.getCurrentLocation();
        RivalRace rivalRace = new RivalRace();
        int optAns = 0;
        while(true) {
            System.out.println("+--------------------------------------------+");
            System.out.println("You are currently in " + trainerCurrLoc);
            System.out.println("+--------------------------------------------+");
            displayChoices(kantoData, trainerCurrLoc);
            System.out.println("+--------------------------------------------+");
            System.out.print("Choice: ");
            int answer = scanner.nextInt();
            System.out.println("+--------------------------------------------+");
            switch(answer) {
                case 1:
                    String newCity = displayCityOption(scanner, trainerCurrLoc, kantoMap);
                    trainerCurrLoc = newCity;
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    optAns = displayOption(scanner);
                    if(optAns == 1) kantoData.displayMap("map", trainerCurrLoc);
                    else if(optAns == 2) trainer.displayPokemon();
                    else if(optAns == 3) trainer.displayBadges();
                    break;
                case 5:
                    if(!trainerCurrLoc.equals("Saffron City")) break;
                    rivalRace.startRivalRace();
                default:
                    break;
            }
            System.out.println();
            if(rivalRace.isRacing()) {
                System.out.println("You are currently in a race with Gary!");
                rivalRace.checkWin(trainerCurrLoc);
            }
            if(optAns == 4) {
                break;
            }
        }
        scanner.close();
    }

    public static int displayOption(Scanner sc) {
        System.out.println("[1] Show Map");
        System.out.println("[2] Show My Pokemon");
        System.out.println("[3] Show My Badges");
        System.out.println("[4] Save and Exit");
        System.out.println("+--------------------------------------------+");
        System.out.print("Choice: ");
        int ans = sc.nextInt();
        return ans;
    }

    public static String displayCityOption(Scanner sc, String currLoc, KantoMap kantoMap) {
        int indexStart = kantoMap.getCityIndex(currLoc);
        String[] neighbors = kantoMap.getNeighborsString(indexStart);
        int i = 0;
        for(; i < neighbors.length; i++) {
            System.out.println("[" + (i + 1) + "]" + neighbors[i]);
        }
        System.out.println("+--------------------------------------------+");
        System.out.print("Choice: ");
        int indexChoice = sc.nextInt();
        if(indexChoice >= neighbors.length) {
            return neighbors[neighbors.length - 1];
        }
        String newCity = neighbors[indexChoice - 1];
        return newCity;
    }


    public static void displayChoices(KantoData kantoData, String currLoc) {
        String currAvailableGym = kantoData.getGymData().get(currLoc);
        if(currAvailableGym == null) {
            currAvailableGym = "No Gym in this city";
        }
        System.out.println("[1] Move to:");
        System.out.println("[2] Challenge Gym Leader [" + currAvailableGym + "]");
        System.out.println("[3] Fight Wild Pokemon");
        System.out.println("[4] Option");
        if(currLoc.equals("Saffron City") && !RivalRace.doneRace) System.out.println("[5] Rival's Race");
    }
}
