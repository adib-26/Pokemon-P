package PokemonBattle;

import java.util.Random;
public class battleMechanism {

    private int allyHP,enemyHP,allyAttk,enemyAttk;
    private String allyType,enemyType;

    private int allyCount = 1, enemyCount = 1;
    private int initialallyHP = 40,initialenemyHP = 40, initialallyLvl = 5;
    public battleMechanism(){
        allyHP = 40;
        enemyHP = 40;
    }

    public static void main(String[] args) {
       battleMechanism b = new battleMechanism();
       b.setAllyType("Grass");
       b.setEnemyType("Water");
        System.out.println(b.updateAllyDmg());
        System.out.println(b.updateEnemyHP());

    }
    public int initialallyHP(){
      return initialallyHP;
    }

    public int initialenemyHP(){
        return initialenemyHP;
    }

    public int initialallyLvl(){return initialallyLvl;}
    public int setAllyDmg(){
       return allyAttk = new Random().nextInt(10);
    }
    public void setAllyType(String allyType){
        this.allyType = allyType;
    }
    public void setEnemyType(String enemyType){
        this.enemyType = enemyType;
    }

    public int updateAllyDmg(){
        if(allyType.equals("Grass") && (enemyType.equals("Water")||enemyType.equals("Rock")||enemyType.equals("Ground"))){
            allyAttk = (setAllyDmg() + setAllyDmg());
        }
        else if(allyType.equals("Grass") && (enemyType.equals("Fire")||enemyType.equals("Flying")||enemyType.equals("Physics"))){
            allyAttk = setAllyDmg()/2;
        }
        return allyAttk;
    }

    public int updateAllyHP(){
            if (allyCount == 1) {
                allyHP = initialallyHP - enemyAttk;
                allyCount = 2;
            } else {
                allyHP -= enemyAttk;
            }

        return allyHP;
    }

    public int setEnemyDmg(){
        return enemyAttk = new Random().nextInt(10);
    }
    public int updateEnemyDmg(){
        if(allyType.equals("Grass") && (enemyType.equals("Water")||enemyType.equals("Rock")||enemyType.equals("Ground"))){
            enemyAttk = (setEnemyDmg() + setEnemyDmg());
        }
        else if(allyType.equals("Grass") && (enemyType.equals("Fire")||enemyType.equals("Flying")||enemyType.equals("Physics"))){
            enemyAttk = setAllyDmg()/2;
        }
        return enemyAttk;
    }

    public int updateEnemyHP(){
        if(enemyCount == 1){
            enemyHP = initialenemyHP - allyAttk;
            enemyCount = 2;
        }
        else
        enemyHP -= allyAttk;

        return enemyHP;
    }
}
