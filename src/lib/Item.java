package lib;

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

    private void addItem(Item[] gameItems, int dex){
        Item add = gameItems[dex];
        add.owned+=1;
    }

    public void addItem(Item[] gameItems, int dex, int n){
        for(int i=0; i<n; i++){addItem(gameItems, dex);};
        String change = "";
        if(dex>0){change=" gained ";}
        else{change=" removed ";}
        System.out.printf("\nYou %s %d %s!", change, n, gameItems[dex].getItemName());
    }

    public void removeItem(Item[] gameItems, int dex){
        addItem(gameItems, -1);
    }

    public void useItem(Item[] gameItems, int dex){
        // more to be added later
        this.removeItem(gameItems, dex);
    }


}