package co.com.sofka.models.pokeapi.singleability;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "effect",
        "language"
})

public class EffectEntry__1 {

    @JsonProperty("effect")
    private String effect;
    @JsonProperty("language")
    private Language__2 language;

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Language__2 getLanguage() {
        return language;
    }

    public void setLanguage(Language__2 language) {
        this.language = language;
    }
}
