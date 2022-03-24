package co.com.sofka.stepdefinition.pokeapi;

import co.com.sofka.models.pokeapi.singleability.Pokemon;
import co.com.sofka.stepdefinition.common.ServiceSetUp;
import co.com.sofka.task.pokeapi.GetSingleAbility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.log4j.Logger;

import static co.com.sofka.question.pokeapi.SingleAbilityResponse.singleAbilityResponse;

//import static co.com.sofka.question.pokeapi.SingleAbilityResponse.singleAbilityResponse;

public class SingleAbilityStepDefinition extends ServiceSetUp {
    private static final Logger LOGGER = Logger.getLogger(SingleAbilityStepDefinition.class);
    private final Actor actor = new Actor("Fan de Pokemon");

    @Given("que el fan se encuentra en el recurso web adecuado para buscar informacion sobre pokemon")
    public void queElFanSeEncuentraEnElRecursoWebAdecuadoParaBuscarInformacionSobrePokemon() {
        generalSetUp();
        actor.can(CallAnApi.at(POKEAPI_BASE_URI));
    }

    @When("el usuario genera la consulta indicando la habilidad {string}")
    public void elUsuarioGeneraLaConsultaIndicandoLaHabilidad(String idOrName) {
        actor.attemptsTo(
                GetSingleAbility.searchByIdOrName(idOrName)
        );
    }

    @Then("observa que uno de los pokemon que tiene esa habilidad es {string}")
    public void observaQueUnoDeLosPokemonQueTieneEsaHabilidadEs(String desiredPokemon) {
//       SingleAbilityResponse singleAbilityResponse = new SingleAbilityResponse();
//       singleAbilityResponse.usingActor(actor);
        LastResponse.received().answeredBy(actor).prettyPrint();


        Pokemon pokemon = singleAbilityResponse().answeredBy(actor)
                .getPokemon().stream().filter(pokemon1 -> pokemon1.getPokemon().getName().equals(desiredPokemon)).findFirst().get();
        LOGGER.info(pokemon);

    }
}
