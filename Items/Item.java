package Items;

public class Item{
    private String name;
    private int itemType, itemUse;

    public Item(){}

    public String getItemName(){return this.name;}
    public int getItemType(){return this.itemType;}
    public int getItemUse(){return this.itemUse;}

    public void setName(String name){this.name = name;}
    public void setItemType(int type){this.itemType = type;}
    public void setItemUse(int use){this.itemUse = use;}

    public void display(){System.out.printf("\nItem name: %s    Item type: %d    Item use: %d", this.getItemName(), this.getItemType(), this.getItemUse());}





}