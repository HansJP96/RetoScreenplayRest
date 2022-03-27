package co.com.sofka.models.pokeapi.singleability;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "is_hidden",
        "slot",
        "pokemon"
})

public class Pokemon {

    @JsonProperty("is_hidden")
    private Boolean isHidden;
    @JsonProperty("slot")
    private Integer slot;
    @JsonProperty("pokemon")
    private Pokemon__1 pokemon;

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

    public Pokemon__1 getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon__1 pokemon) {
        this.pokemon = pokemon;
    }
}
