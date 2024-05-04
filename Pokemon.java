/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElementalCreatures;

/**
 *
 * @author User
 */
public abstract class Pokemon {
    private int dexNo, typeOne, typeTwo, noOfEvolution;
    private String name;
    private Evolvable[] evolution;
    private Move[] movesets;
    
    // initialize a Pokemon Object
    public Pokemon(){
        this.dexNo = 0;
        this.name = null;
        this.typeOne = 0;
        this.typeTwo = 0;
        this.noOfEvolution = 0;
    }
    
    public int getDexNo(){return this.dexNo;}
    public int typeOne(){return this.typeOne;}
    public int typeTwo(){return this.typeTwo;}
    public int getNoOfEvolution(){return this.noOfEvolution;}
    public String getName(){return this.name;}
    public Evolvable[] getEvolution(){return this.evolution;}
    public Move[] getMovesets(){return this.movesets;}
    
    public void setDexNo(int no){this.dexNo = no;}
    public void setTypeOne(int type){this.typeOne = type;}
    public void setTypeTwo(int type){this.typeTwo = type;}
    public void setNoOfEvolution(int number){this.noOfEvolution = number;}
    public void setName(String name){this.name = name;}
    public abstract void initializeEvolution();
    public abstract void initializeMovesets();
    
    
    
}
