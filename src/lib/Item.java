package lib;
import entity.TrainerPokemon;
public class Item{
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

    public void useItem(TrainerPokemon pokemon){
        // more to be added later
        switch(this.itemType){
            case 0:
                this.useHealingItem(pokemon);
                break;
            case 2:
                this.useEvoItem(pokemon);
                break;
            default:
                System.out.printf("\nThis item cannot be used outside certain conditions.");
                break;
        }
    }

    public void useHealingItem(TrainerPokemon pokemon){
        String condition = this.getItemCond();
        if (condition.substring(0,1).compareTo("H")==0){
            if(condition.equals("H")){pokemon.recoverHP(pokemon.getMaxHP()-pokemon.getCurrentHP());}
            else{pokemon.recoverHP(Integer.parseInt(condition.substring(1, condition.length())));}
            removeItem();
        }
        else if (condition.substring(0,1).compareTo("S")==0){
            if(condition.equals("S")){
                if(pokemon.getStatus()!=null){
                    System.out.println("Pokemon isn't afflicted with any status!");
                    return;
                }
                else{
                    pokemon.setStatus("null");
                    removeItem();
                }
            }
        // more to be added afterwards;
        // add pp to each move
        // pokemon revival
    }

    public void useEvoItem(TrainerPokemon pokemon){

    }


}