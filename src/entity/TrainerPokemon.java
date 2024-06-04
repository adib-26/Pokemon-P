package entity;
import lib.Moves;
import lib.Item;
public class TrainerPokemon {
    private Pokemon pokemon;
    private int maxHP, currentHP, exp, maxEXP, lvl;
    private String status;
    private boolean fainted;
    private Moves[] currentMovesets = new Moves[4];

    public TrainerPokemon(Pokemon[] pokedex, String name, int level, String status){
        int dex = Pokemon.getDexNo(name, pokedex);
        this.setPokemon(pokedex[dex]);
        this.setLevel(level);
        this.setEXP(0);
        this.updateEXPMax();
        this.setStatus(status);
        this.setMaxHP(15+(level-5)*3);//some random values
        this.currentHP = this.maxHP;
        int i = 0;
        while(true){
            if (this.pokemon.getMovesets().peek().getLevel()<=this.lvl){
                this.currentMovesets[i] = this.pokemon.getMovesets().peek().getMove();
                this.pokemon.getMovesets().poll();
            } else{break;}
            i++;
        }
    }



    public int getMaxHP(){return this.maxHP;}
    public int getCurrentHP(){return this.currentHP;}
    public int getEXP(){return this.exp;}
    public int getLevel(){return this.lvl;}
    public String getStatus(){return this.status;}
    public Moves[] getCurrentMoveset(){return this.currentMovesets;}
    public Pokemon getPokemon(){return this.pokemon;}
    public boolean hasFainted(){return this.fainted;}

    public void setMaxHP(int hp){this.maxHP = hp;}
    public void setEXP(int exp){this.exp = exp;}
    public void setLevel(int level){this.lvl = level;}
    public void setStatus(String status){this.status = status;}
    public void setPokemon(Pokemon pokemon){this.pokemon = pokemon;}
    public void recoverHP(int hp){
        if(this.currentHP + hp > this.maxHP){
            this.recoverHP(this.maxHP-this.currentHP);
            return;
        }
        this.currentHP += hp;
    }
    public void updateEXPMax(){
        if(this.lvl<=10){this.maxEXP = 100;}
        else if(this.lvl<=30){this.maxEXP = 200;}
        else{this.maxEXP = 300;}
    }
    public void updateLevel(){
        if(this.exp>=this.maxEXP){
            this.lvl += 1;
            this.exp -=this.maxEXP;
        }
    }

    public void checkHasFainted(){
        if (this.currentHP ==0){this.fainted = true;}
        if(this.currentHP !=0){this.fainted = false;}
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

    public void showDetails(){
        System.out.printf("Pokemon: %s \nLevel: %d \nCurrent EXP: %d \nEXP needed to level up: %d", this.getPokemon().getName(), this.getLevel(), this.getEXP(), this.maxEXP-this.getEXP());
        System.out.printf("\nCurrent Movesets: ");
        for (int i=0; currentMovesets[i]!=null; i++){
            System.out.printf("\n-%s          %d  %d", currentMovesets[i].getName(), currentMovesets[i].getBP(), currentMovesets[i].getPP());
        }
        System.out.printf("\nCurrent Status: %s ", this.getStatus());
        this.getPokemon().showTypingDetails();
    }





}



