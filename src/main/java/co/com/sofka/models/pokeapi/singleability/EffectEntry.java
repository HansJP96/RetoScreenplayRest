package co.com.sofka.models.pokeapi.singleability;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "effect",
        "short_effect",
        "language"
})

public class EffectEntry {

    @JsonProperty("effect")
    private String effect;
    @JsonProperty("short_effect")
    private String shortEffect;
    @JsonProperty("language")
    private Language__1 language;

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getShortEffect() {
        return shortEffect;
    }

    public void setShortEffect(String shortEffect) {
        this.shortEffect = shortEffect;
    }

    public Language__1 getLanguage() {
        return language;
    }

    public void setLanguage(Language__1 language) {
        this.language = language;
    }
}
