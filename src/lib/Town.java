package src.lib;
import src.entity.Trainer;
import src.entity.TrainerPokemon;

public class Town {
    private String name;
    Pokemart pokemart;
    Gym gym;
    
    public Town(String n){
        this.name = n;
    }

    public static void goToPokemonCenter(Trainer trainer){
        for (int i=0; i<trainer.getAllPokemon().size(); i++){
            TrainerPokemon pokemon = trainer.getAllPokemon().get(i);
            pokemon.recoverHP(pokemon.getMaxHP()-pokemon.getCurrentHP());
        }
        System.out.printf("\nAll your Pokemon has been healed");
    }
}
