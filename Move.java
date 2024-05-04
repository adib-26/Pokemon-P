/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ElementalCreatures;

/**
 *
 * @author User
 */
public class Move {
    String moveName;
    int level, type, effect, bp, pp, acc;
    public Move(String moveName, int level, int type, int effect, int bp, int pp, int acc){
        this.moveName = moveName;
        this.level = level;
        this.type = type;
        this.effect = effect;
        this.bp = bp;
        this.pp = pp;
        this.acc = acc;
    }
    
}
