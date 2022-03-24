package co.com.sofka.models.pokeapi.singleability;

public class Name {

    public String name;
    public LanguageName languageName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LanguageName getLanguage() {
        return languageName;
    }

    public void setLanguage(LanguageName languageName) {
        this.languageName = languageName;
    }
}
