package co.com.sofka.util;

public enum PokeApiResources {
    SINGLE_ABILITY_RESOURCE("/api/v2/ability/{IdOrName}");

    private final String value;

    PokeApiResources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
