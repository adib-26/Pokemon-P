package PokemonBattle;

import java.util.Random;
public class battleMechanism {

    private int allyHP,enemyHP,allyAttk,enemyAttk;
    private String allyType,enemyType;

    battleMechanism(){
        allyHP = 40;
        enemyHP = 40;
    }

    public static void main(String[] args) {
       battleMechanism b = new battleMechanism();
        System.out.println(b.updateAllyDmg("Grass","Water"));
        System.out.println(b.updateAllyHP("Grass","Water"));

    }

    void setText(){
        System.out.println("hi");
    }
    public int setAllyDmg(){
       return allyAttk = new Random().nextInt(10);
    }

    public int updateAllyDmg(String allyType,String enemyType){
        if(allyType.equals("Grass") && (enemyType.equals("Water")||enemyType.equals("Rock")||enemyType.equals("Ground"))){
            allyAttk = (setAllyDmg() + setAllyDmg());
        }
        else if(allyType.equals("Grass") && (enemyType.equals("Fire")||enemyType.equals("Flying")||enemyType.equals("Physics"))){
            allyAttk = setAllyDmg()/2;
        }
        return allyAttk;
    }

    public int updateAllyHP(String allyType,String enemyType){
       return allyHP -= updateEnemyDmg(allyType,enemyType);
    }

    public int setEnemyDmg(){
        return enemyAttk = new Random().nextInt(10);
    }
    public int updateEnemyDmg(String allyType,String enemyType){
        if(allyType.equals("Grass") && (enemyType.equals("Water")||enemyType.equals("Rock")||enemyType.equals("Ground"))){
            enemyAttk = (setEnemyDmg() + setEnemyDmg());
        }
        else if(allyType.equals("Grass") && (enemyType.equals("Fire")||enemyType.equals("Flying")||enemyType.equals("Physics"))){
            enemyAttk = setAllyDmg()/2;
        }
        return enemyAttk;
    }

    public int updateEnemyHP(String allyType,String enemyType){
        return enemyHP -= updateAllyDmg(allyType,enemyType);
    }
}
