package co.com.sofka.models.pokeapi.singleability;

public class EffectEntry {

    public String effect;
    public String shortEffect;
    public LanguageEffectEntry language;

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

    public LanguageEffectEntry getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEffectEntry language) {
        this.language = language;
    }
}
