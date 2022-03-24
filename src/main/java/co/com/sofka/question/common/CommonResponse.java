package co.com.sofka.question.common;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CommonResponse implements Question<Object> {
    private Actor actor;

    @Override
    public Object answeredBy(Actor actor) {
        this.actor = actor;
        return SerenityRest.lastResponse().as(this.getClass());
    }

    public void httpResponseStateOk() {
        actor.should(
                seeThatResponse("El código de respuesta debe ser: " + HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)
                )
        );
    }

    public void consolePrintResponse() {
        LastResponse.received().answeredBy(actor).prettyPrint();
    }
}
