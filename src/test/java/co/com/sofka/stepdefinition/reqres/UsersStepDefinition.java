package co.com.sofka.stepdefinition.reqres;

import co.com.sofka.stepdefinition.common.ServiceSetUp;
import co.com.sofka.task.reqres.DeleteUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.notNullValue;

public class UsersStepDefinition extends ServiceSetUp {

    private static final Logger LOGGER = Logger.getLogger(UsersStepDefinition.class);
    private static final Actor admin = new Actor("Administrador");

    @Given("que se tiene acceso al recurso web adecuado")
    public void queSeTieneAccesoAlRecursoWebAdecuado() {
        try {
            generalSetUp();
            admin.can(CallAnApi.at(REQRES_BASE_URI));
        } catch (Exception exception) {
            LOGGER.warn("Error ingresando al recurso base", exception);
        }
    }

    @When("quiero eliminar un usuario con id = {int}")
    public void quieroEliminarUnUsuarioConId(Integer id) {
        try {
            admin.attemptsTo(
                    DeleteUser
                            .deleteUserById(id)
            );
        } catch (Exception exception){
            LOGGER.warn("Error realizando la peticion al endpoint", exception);
        }
    }

    @Then("se tiene como resultado una peticion existosa")
    public void seTieneComoResultadoUnaPeticionExistosa() {
        admin.should(
                seeThatResponse("el codigo de respuest correcto es " + HttpStatus.SC_NO_CONTENT,
                        status -> status.statusCode(HttpStatus.SC_NO_CONTENT))
        );
    }

}
