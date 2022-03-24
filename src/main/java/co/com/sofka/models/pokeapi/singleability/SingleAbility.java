package co.com.sofka.models.pokeapi.singleability;

import java.util.List;

public class SingleAbility {

    public Integer id;
    public String name;
    public Boolean isMainSeries;
    public Generation generation;
    public List<Name> names = null;
    public List<EffectEntry> effectEntries = null;
    public List<EffectChange> effectChanges = null;
    public List<FlavorTextEntry> flavorTextEntries = null;
    public List<Pokemon> pokemon = null;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMainSeries() {
        return isMainSeries;
    }

    public void setMainSeries(Boolean mainSeries) {
        isMainSeries = mainSeries;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<EffectEntry> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<EffectEntry> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public List<EffectChange> getEffectChanges() {
        return effectChanges;
    }

    public void setEffectChanges(List<EffectChange> effectChanges) {
        this.effectChanges = effectChanges;
    }

    public List<FlavorTextEntry> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<FlavorTextEntry> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}


