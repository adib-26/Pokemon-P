package entity;
import lib.Moves;
import lib.Item;
public class TrainerPokemon {
    private Pokemon pokemon;
    private int hp, exp, expMax, lvl;
    private String status;
    private Moves[] currentMovesets = new Moves[4];

    public TrainerPokemon(Pokemon[] pokedex, String name, int level, String status){
        int dex = Pokemon.getDexNo(name, pokedex);
        this.setPokemon(pokedex[dex]);
        this.setLevel(level);
        this.setEXP(0);
        this.updateEXPMax();
        this.setStatus(status);
        this.setHP(15+(level-5)*3);//some random values
        int i = 0;
        while(true){
            if (this.pokemon.getMovesets().peek().getLevel()<=this.lvl){
                this.currentMovesets[i] = this.pokemon.getMovesets().peek().getMove();
                this.pokemon.getMovesets().poll();
            } else{break;}
            i++;
        }
    }



    public int getHP(){return this.hp;}
    public int getEXP(){return this.exp;}
    public int getLevel(){return this.lvl;}
    public String getStatus(){return this.status;}
    public Moves[] getCurrentMoveset(){return this.currentMovesets;}
    public Pokemon getPokemon(){return this.pokemon;}

    public void setHP(int hp){this.hp = hp;}
    public void setEXP(int exp){this.exp = exp;}
    public void setLevel(int level){this.lvl = level;}
    public void setStatus(String status){this.status = status;}
    public void setPokemon(Pokemon pokemon){this.pokemon = pokemon;}
    public void updateEXPMax(){
        if(this.lvl<=10){this.expMax = 100;}
        else if(this.lvl<=30){this.expMax = 200;}
        else{this.expMax = 300;}
    }
    public void updateLevel(){
        if(this.exp>=this.expMax){
            this.lvl += 1;
            this.exp -=this.expMax;
        }
    }

    public void evolvePokemon(){
        boolean canEvolve = false;
        int i = 0;
        while(i<this.pokemon.getEvolutions().size()){
            if(this.pokemon.getEvolutions().get(i).getEvolutionType()==0){
                if(this.pokemon.getEvolutions().get(i).getEvolutionCond()<=this.getLevel()){
                    this.pokemon = this.pokemon.getEvolutions().get(i).getPokemon();
                    canEvolve = true;
                }
            }
            i++;
        }
        if(canEvolve){System.out.printf("\nYour Pokemon has evolved into a %s!", this.pokemon.getName());}
        
    }

    public void evolvePokemon(Item evoItem){
        boolean canEvolve = false;
        int i = 0;
        while(i<this.pokemon.getEvolutions().size()){
            if(this.pokemon.getEvolutions().get(i).getEvolutionType()==1){
                if(this.pokemon.getEvolutions().get(i).getEvolutionCond()==Integer.parseInt(evoItem.getItemCond())){
                    this.pokemon = this.pokemon.getEvolutions().get(i).getPokemon();
                    canEvolve = true;
                }
            }
            i++;
        }
        if(canEvolve){System.out.printf("\nYour Pokemon has evolved into a %s!", this.pokemon.getName());}
        
    }



}

