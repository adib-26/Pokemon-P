package ElementalCreatures;


public class Evolution {
    private Pokemon pokemon;
    private int evoType, cond;
    public Evolution(Pokemon poke, int type, int cond){
        this.pokemon = poke;
        this.evoType = type;
        this.cond = cond;
    }

    public Pokemon getPokemon(){return this.pokemon;}
    public int getEvolutionType(){return this.evoType;}
    public int getEvolutionCond(){return this.cond;}

    @Override
    public String toString(){
        String condition = "";
        if (this.evoType == 0){
            condition = " evolves into " + this.getPokemon().getName() + " at level " + this.getEvolutionCond() + "!";
        } else if (this.evoType == 1){
            condition = " evolves into "  + this.getPokemon().getName() + " by using a stone!";
        } else{
            condition = " evolves into " + this.getPokemon().getName() + " through trading!";
        }
        return condition;
    }


}
