package lib;
public class Moves {
    private String name;
    private int moveType, bp, pp, typing;
    private double acc;
    private int effect;

    public Moves(){}

    public String getName(){return this.name;}
    public int getMoveType(){return this.moveType;}
    public int getBP(){return this.bp;}
    public int getPP(){return this.pp;}
    public int getTyping(){return this.typing;}
    public double getAcc(){return this.acc;}
    public int getEffect(){return this.effect;}

    public void setName(String name){this.name = name;}
    public void setMoveType(int type){this.moveType = type;}
    public void setBP(int bp){this.bp = bp;}
    public void setPP(int pp){this.pp = pp;}
    public void setTyping(int typing){this.typing = typing;}
    public void setAcc(double acc){this.acc = acc;}
    public void setEffect(int effect){this.effect = effect;}

    
}
