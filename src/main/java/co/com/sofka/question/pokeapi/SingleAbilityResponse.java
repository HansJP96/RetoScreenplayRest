package co.com.sofka.question.pokeapi;

import co.com.sofka.models.pokeapi.singleability.SingleAbility;
import co.com.sofka.question.common.CommonResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SingleAbilityResponse implements Question<SingleAbility> {

    private Actor actor;

    public static SingleAbilityResponse singleAbilityResponse() {
        return new SingleAbilityResponse();
    }


    public SingleAbility answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(SingleAbility.class);
    }

    public void usingActor(Actor actor){
        this.actor=actor;
    }

    public SingleAbility accessResponse(){
        return (SingleAbility) answeredBy(actor);
    }

//    @Override
//    public void httpResponseStateOk() {
//        super.httpResponseStateOk();
//    }
//
//    @Override
//    public void consolePrintResponse() {
//        super.consolePrintResponse();
//    }

    //    @Override
//    public SingleAbility answeredBy(Actor actor) {
//        return SerenityRest.lastResponse().as(SingleAbility.class);
//    }
}
