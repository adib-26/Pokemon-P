package PokemonBattle;

import java.util.Random;
public class battleMechanism {

    private static int allyHP,enemyHP,allyAttk,enemyAttk;
    private String allyType,enemyType;

    private static int allyCount = 1, enemyCount = 1;
    private int initialallyHP = 40,initialenemyHP = 40, initialallyLvl = 5;
    public battleMechanism(){
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
    public int getAllyHP(){
        return allyHP;
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
            if(allyHP<=0 || enemyHP<=0) {
                allyCount = 1;
                enemyCount = 1;
            }
            //setTempAllyHP(allyHP);
        return allyHP;
    }

    public int setEnemyDmg(){
        return enemyAttk = new Random().nextInt(10);
    }
    public void setTempEnemyHP(int enemyHP){
       this.enemyHP = enemyHP;
    }
    public int getEnemyHP(){
        return enemyHP;
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
        System.out.println(enemyCount);
        System.out.println(enemyHP);
        if(enemyCount == 1){
            enemyHP = initialenemyHP - allyAttk;
            enemyCount = 2;
        }
        else
        enemyHP -= allyAttk;
        if(enemyHP<=0)
            enemyCount = 1;
        setTempEnemyHP(enemyHP);
        return enemyHP;
    }
}
