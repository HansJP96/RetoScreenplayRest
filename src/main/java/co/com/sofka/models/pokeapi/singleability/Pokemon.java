package co.com.sofka.models.pokeapi.singleability;

public class Pokemon {

    public Boolean isHidden;
    public Integer slot;
    public PokemonPokemon pokemon;

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public PokemonPokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(PokemonPokemon pokemon) {
        this.pokemon = pokemon;
    }
}
