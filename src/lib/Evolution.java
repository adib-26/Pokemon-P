package lib;

public class Evolution {
int typeEvolve;
int condition;
public Evolution(){
    this.typeEvolve = 0;
    this.condition = 0;
}

public int getTypeEvolve(){return this.typeEvolve;}
public int getEvolveCondition(){return this.condition;}

public void setTypeEvolve(int type){this.typeEvolve = type;}
public void setCondition(int condition){this.condition = condition;}
}
