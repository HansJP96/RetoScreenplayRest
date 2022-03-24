package co.com.sofka.models.pokeapi.singleability;

public class FlavorTextEntry {

    public String flavorText;
    public LanguageFlavorTextEntry language;
    public VersionGroupFlavorTextEntry versionGroup;

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public LanguageFlavorTextEntry getLanguage() {
        return language;
    }

    public void setLanguage(LanguageFlavorTextEntry language) {
        this.language = language;
    }

    public VersionGroupFlavorTextEntry getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroupFlavorTextEntry versionGroup) {
        this.versionGroup = versionGroup;
    }
}
