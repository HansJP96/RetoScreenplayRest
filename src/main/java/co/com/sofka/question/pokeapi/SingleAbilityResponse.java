package co.com.sofka.question.pokeapi;

import co.com.sofka.models.pokeapi.singleability.AbilityModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SingleAbilityResponse implements Question<AbilityModel> {


    public static SingleAbilityResponse singleAbilityResponse() {
        return new SingleAbilityResponse();
    }

    public AbilityModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(AbilityModel.class);
    }

}
