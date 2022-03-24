package co.com.sofka.models.pokeapi.singleability;

import java.util.List;

public class EffectChange {

    public VersionGroupEffectChange versionGroupEffectChange;
    public List<EffectEntryEffectChange> effectEntryEffectChanges = null;



    public VersionGroupEffectChange getVersionGroup() {
        return versionGroupEffectChange;
    }

    public void setVersionGroup(VersionGroupEffectChange versionGroupEffectChange) {
        this.versionGroupEffectChange = versionGroupEffectChange;
    }

    public List<EffectEntryEffectChange> getEffectEntryEffectChanges() {
        return effectEntryEffectChanges;
    }

    public void setEffectEntryEffectChanges(List<EffectEntryEffectChange> effectEntryEffectChanges) {
        this.effectEntryEffectChanges = effectEntryEffectChanges;
    }
}
