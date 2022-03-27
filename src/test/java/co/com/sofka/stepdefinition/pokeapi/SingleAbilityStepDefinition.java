package co.com.sofka.stepdefinition.pokeapi;

import co.com.sofka.models.pokeapi.singleability.Pokemon;
import co.com.sofka.stepdefinition.common.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.log4j.Logger;

import java.util.Objects;


import static co.com.sofka.question.common.CommonResponse.checkHttpResponseStateOk;
import static co.com.sofka.question.common.CommonResponse.consolePrintResponse;
import static co.com.sofka.question.pokeapi.SingleAbilityResponse.singleAbilityResponse;
import static co.com.sofka.task.pokeapi.GetSingleAbility.searchByIdOrName;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;


public class SingleAbilityStepDefinition extends ServiceSetUp {
    private static final Logger LOGGER = Logger.getLogger(SingleAbilityStepDefinition.class);
    private final Actor fan = new Actor("Fan de Pokemon");

    @Given("que el fan se encuentra en el recurso web adecuado para buscar informacion sobre pokemon")
    public void queElFanSeEncuentraEnElRecursoWebAdecuadoParaBuscarInformacionSobrePokemon() {
        try {
            generalSetUp();
            fan.can(CallAnApi.at(POKEAPI_BASE_URI));
        } catch (Exception exception) {
            LOGGER.warn("Error ingresando al recurso base", exception);
        }
    }

    @When("el usuario genera la consulta indicando la habilidad {string}")
    public void elUsuarioGeneraLaConsultaIndicandoLaHabilidad(String idOrName) {
        try {
            fan.attemptsTo(
                    searchByIdOrName(idOrName)
            );
        } catch (Exception exception) {
            LOGGER.warn("Error solicitando el endpoint", exception);
        }
    }

    @Then("observa que uno de los pokemon que tiene esa habilidad es {string}")
    public void observaQueUnoDeLosPokemonQueTieneEsaHabilidadEs(String desiredPokemon) {

        consolePrintResponse(fan);
        checkHttpResponseStateOk(fan);

        Pokemon pokemon = singleAbilityResponse().answeredBy(fan)
                .getPokemon().stream()
                .filter(pokemon1 -> pokemon1.getPokemon().getName().equals(desiredPokemon))
                .findFirst().orElse(null);


        fan.should(
                seeThat("la busqueda de pokemon es no nula", searching -> pokemon, notNullValue())
        );

        fan.should(
                seeThat("el nombre del pokemon si coincide",
                        searchName -> Objects.requireNonNull(pokemon).getPokemon().getName(), equalTo(desiredPokemon))
        );

    }
}
