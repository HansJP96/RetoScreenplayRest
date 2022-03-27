package co.com.sofka.question.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CommonResponse  {
    private static final Logger LOGGER = Logger.getLogger(CommonResponse.class);

    public static void checkHttpResponseStateOk(Actor actor) {
        actor.should(
                seeThatResponse("El código de respuesta debe ser: " + HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)
                )
        );
    }

    public static void checkHttpResponseStateForCreations(Actor actor) {
        actor.should(
                seeThatResponse("El código de respuesta debe ser: " + HttpStatus.SC_CREATED,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_CREATED)
                )
        );
    }


    public static void consolePrintResponse(Actor actor) {
        LOGGER.info("Respuesta de la peticion :");
        LastResponse.received().answeredBy(actor).prettyPrint();
    }
}
