package co.com.sofka.models.pokeapi.singleability;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "flavor_text",
        "language",
        "version_group"
})

public class FlavorTextEntry {

    @JsonProperty("flavor_text")
    private String flavorText;
    @JsonProperty("language")
    private Language__3 language;
    @JsonProperty("version_group")
    private VersionGroup__1 versionGroup;

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public Language__3 getLanguage() {
        return language;
    }

    public void setLanguage(Language__3 language) {
        this.language = language;
    }

    public VersionGroup__1 getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup__1 versionGroup) {
        this.versionGroup = versionGroup;
    }
}
