package co.com.sofka.stepdefinition.jsonplaceholder;

import co.com.sofka.models.jsonplaceholder.CommentsModel;
import co.com.sofka.question.jsonplaceholder.CommentsResponse;
import co.com.sofka.stepdefinition.common.ServiceSetUp;
import co.com.sofka.task.jsonplaceholder.CreateComment;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.log4j.Logger;


import static co.com.sofka.question.common.CommonResponse.*;
import static co.com.sofka.question.jsonplaceholder.CommentsResponse.commentsResponse;
import static co.com.sofka.task.jsonplaceholder.UpdateComment.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;


public class CommentsStepDefinition extends ServiceSetUp {
    private static final Logger LOGGER = Logger.getLogger(CommentsStepDefinition.class);
    private final CommentsModel commentsModel = new CommentsModel();
    private final Actor user = new Actor("Usuario");
    private final Faker faker = new Faker();

    @Given("que el usuario estoy en el recurso web de la pagina")
    public void queElUsuarioEstoyEnElRecursoWebDeLaPagina() {
        try {
            generalSetUp();
            user.can(CallAnApi.at(JSONPLACEHOLDER_BASE_URI));
        } catch (Exception exception) {
            LOGGER.warn("Error ingresando al recurso base", exception);
        }
    }

    @When("se quiere modificar un mensaje identificado por id= {string} y se cambia el nombre por {string} y el cuerpo por {string}")
    public void seQuiereModificarUnMensajeIdentificadoPorIdYSeCambiaElNombrePorYElCuerpoPor(String id, String newName, String newBody) {
        commentsModel.setName(newName);
        commentsModel.setBody(newBody);

        user.attemptsTo(
                updateComment()
                        .typeNewData(commentsModel)
                        .andSendChangesToPostById(id)
        );
    }


    @Then("se observa que el contenido que se modifico se ha actualizado correctamente")
    public void seObservaQueElContenidoQueSeModificoSeHaActualizadoCorrectamente() {
        consolePrintResponse(user);
        checkHttpResponseStateOk(user);

        CommentsModel userComment = commentsResponse().answeredBy(user);

        user.should(
                seeThat("el comentario retorna un id no nulo",
                        comment -> userComment.getId(), notNullValue())
        );

        user.should(
                seeThat("el comentario posee el nombre actualizado",
                        comment -> userComment.getName(), equalTo(commentsModel.getName())),
                seeThat("el comentario posee el cuerpo actualizado",
                        comment -> userComment.getBody(), equalTo(commentsModel.getBody()))
        );
    }

    @When("se quiere escribir un nuevo mensaje para el post con id {int} y escribo el nombre del mensaje, un email y el cuerpo")
    public void seQuiereEscribirUnNuevoMensajeParaElPostConIdYEscriboElNombreDelMensajeUnEmailYElCuerpo(Integer idPost) {
        commentsModel.setPostId(idPost);
        commentsModel.setEmail(faker.internet().emailAddress());
        commentsModel.setName(faker.lorem().sentence(5));
        commentsModel.setBody(faker.lorem().paragraph());
        try {
            user.attemptsTo(
                    CreateComment
                            .typeOnPostCommentData(commentsModel)
            );
        }catch (Exception exception){
            LOGGER.warn("Error realizando la peticion al endpoint", exception);
        }
    }

    @Then("se observa que el mensaje se ha creado correctamente")
    public void seObservaQueElMensajeSeHaCreadoCorrectamente() {
        consolePrintResponse(user);
        checkHttpResponseStateForCreations(user);

        CommentsModel comments = commentsResponse().answeredBy(user);
        user.should(
                seeThat("se creo el mensaje con un id no nulo",
                        newComment -> comments.getId(), notNullValue())
        );

        user.should(
                seeThat("el email de su mensaje",
                        newComment -> comments.getEmail(), containsString(commentsModel.getEmail())),
                seeThat("el nombre de su mensaje",
                        newComment -> comments.getName(), containsString(commentsModel.getName())),
                seeThat("el cuerpo de su mensaje",
                        newComment -> comments.getBody(), containsString(commentsModel.getBody()))

        );
    }

}
