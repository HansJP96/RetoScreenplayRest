package co.com.sofka.models.pokeapi.singleability;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "version_group",
        "effect_entries"
})

public class EffectChange {

    @JsonProperty("version_group")
    private VersionGroup versionGroup;
    @JsonProperty("effect_entries")
    private List<EffectEntry__1> effectEntries = null;

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

    public List<EffectEntry__1> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<EffectEntry__1> effectEntries) {
        this.effectEntries = effectEntries;
    }
}
