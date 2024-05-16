package lib;
import java.util.Scanner;
import entity.Pokemon;
import entity.Trainer;
import entity.TrainerPokemon;

public class Item{
    static Scanner sc = new Scanner(System.in);
    private int itemNo, owned, itemType;
    private String name, cond;

    public Item(int i, int t, String n, String c){
        this.owned = 0;
        this.setItemDex(i);
        this.setItemType(t);
        this.setItemName(n);
        this.setItemCond(c);
    }

    public int getItemDex(){return this.itemNo;}
    public int getNumberOwned(){return this.owned;}
    public int getItemType(){return this.itemType;}
    public String getItemName(){return this.name;}
    public String getItemCond(){return this.cond;}

    public void setItemDex(int i){this.itemNo = i;}
    public void setItemType(int t){this.itemType = t;}
    public void setItemName(String n){this.name = n;}
    public void setItemCond(String c){this.cond = c;}

    private void addItem(){this.owned+=1;}

    

    public void addItem(int n){
        for(int i=0; i<n; i++){addItem();};
        String change = "";
        if(n>0){change=" gained ";}
        else{change=" removed ";}
        System.out.printf("\nYou %s %d %s!", change, n, this.getItemName());
    }

    public void removeItem(){
        if(this.owned<0){
            System.out.printf("\nYou don't have this item!");
            return;}
        addItem(-1);
    }

    private static TrainerPokemon choosePokemon(Trainer trainer){
        TrainerPokemon choosen = null;
        System.out.printf("\nPlease choose a Pokemon: ");
        for(int i=0; i<trainer.getAllPokemon().size(); i++){
            System.out.printf("\n[%d] %s   -  Level %d", (i+1), trainer.getAllPokemon().get(i).getPokemon().getName(), trainer.getAllPokemon().get(i).getLevel());
        }
        int n = 0;
        while(n<=0||n>trainer.getAllPokemon().size()){n=sc.nextInt();}
        choosen = trainer.getAllPokemon().get(n-1);
        return choosen;
    }

    private static Moves chooseMove(TrainerPokemon pokemon){
        Moves choosen = null;
        System.out.printf("\nPlease choose a move: ");
        for(int i=0; i<pokemon.getCurrentMoveset().length; i++){
            System.out.printf("\n[%d] %s  - PP: %d", (i+1), pokemon.getCurrentMoveset()[i].getName(), pokemon.getCurrentMoveset()[i].getPP());
        }
        int n =0;
        while(n<=0||n>4){n=sc.nextInt();}
        choosen = pokemon.getCurrentMoveset()[n];
        return choosen;
    }

    public void useItem(Trainer trainer){
        switch(this.getItemType()){
            case 0:
                this.useHealingItem(trainer);
                break;
            case 2:
                this.useEvoItem(trainer);
                break;
            default:
                System.out.printf("\nCannot use this item outside of certain conditions.");
                break;
        }
    }

    private void useHealingItem(Trainer trainer){
        String condition = this.getItemCond();
        TrainerPokemon pokemon = null;
        Moves move = null;
        // recover hp
        if(condition.startsWith("H")){
            pokemon = choosePokemon(trainer);
            if(condition.equals("H")){pokemon.recoverHP(pokemon.getMaxHP()-pokemon.getCurrentHP());}
            else{pokemon.recoverHP(Integer.parseInt(condition.substring(1)));}
        } else if(condition.startsWith("P")){
            pokemon = choosePokemon(trainer);
            move = chooseMove(pokemon);
            if(condition.equals("P")){move.setPP(move.getPP());}
            move.setPP(10);
        } else if(condition.startsWith("S")){
            pokemon = choosePokemon(trainer);
            if(pokemon.getStatus()==null){
                System.out.println("Pokemon isn't afficted with anything!");
                return;
            }
            if(pokemon.getStatus()!=null&&condition.equals("S")){
                pokemon.setStatus(null);}
            String cureStatus = "";
            switch (Integer.parseInt(condition.substring(1))){
                case 0:
                    cureStatus="poison";
                    break;
                case 1:
                     cureStatus="burn";
                     break;
                case 2:
                     cureStatus="freeze";
                     break;
                case 3:
                     cureStatus="asleep";
                     break;
                case 4:
                     cureStatus="paralyze";
                     break;
                default:
                     break;
            }
            if(cureStatus.equals(pokemon.getStatus())){
                pokemon.setStatus(null);
                System.out.printf("\nPokemon has been cured from status condition!");
            } else{System.out.printf("\nPokemon cannot be cured!");}
        } else if(condition.equals("F")){
            pokemon = choosePokemon(trainer);
            pokemon.recoverHP(pokemon.getMaxHP()-pokemon.getCurrentHP());
            pokemon.setStatus(null);
            System.out.printf("\nPokemon has been fully cured!");
        } else if(condition.startsWith("R")){
            pokemon = choosePokemon(trainer);
            if(!pokemon.hasFainted()){System.out.printf("\nYou cannot revive this Pokemon!");}
            if(condition.equals("R")){
   
                pokemon.recoverHP(pokemon.getMaxHP());
                pokemon.checkHasFainted();
                pokemon.setStatus(null);
                System.out.printf("\nPokemon has been revived!");
  
            }
            else{
                pokemon.recoverHP(pokemon.getMaxHP());
                pokemon.checkHasFainted();   
                pokemon.setStatus(null);
                System.out.printf("\nPokemon has been revived!");
            }
        } else if(condition.startsWith("E")){
            pokemon = choosePokemon(trainer);
            if(condition.equals("E")){
                for(int i=0; i<pokemon.getCurrentMoveset().length; i++){
                    pokemon.getCurrentMoveset()[i].setPP(pokemon.getCurrentMoveset()[i].getPP());
                }
            } else{
                for(int i=0; i<pokemon.getCurrentMoveset().length; i++){
                    pokemon.getCurrentMoveset()[i].setPP(10);
                }
            }

        }
    }


    private void useEvoItem(Trainer trainer){
        TrainerPokemon pokemon = choosePokemon(trainer);
        pokemon.evolvePokemon(this);
    }






}