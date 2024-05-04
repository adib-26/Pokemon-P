/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElementalCreatures;

/**
 *
 * @author User
 */
public class Evolvable {
    boolean canEvolve;
    int numOfEvolution, typeOfEvolution, condition;
    
    public Evolvable(){
        this.canEvolve = false;
        this.numOfEvolution = 0;
        this.typeOfEvolution = 0;
        this.condition = 0;
    }
    
    public boolean getEvolvable(){return this.canEvolve;}
    public int getNumOfEvolutiom(){return this.numOfEvolution;}
    public int getTypeOfEvolution(){return this.typeOfEvolution;}
    public int getCondition(){return this.condition;}
    
}
