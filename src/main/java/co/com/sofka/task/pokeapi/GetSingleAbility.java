package co.com.sofka.task.pokeapi;

import co.com.sofka.util.PokeApiResources;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetSingleAbility implements Task {

    private  final String endPointByIdOrName;

    public GetSingleAbility(String endPointByIdOrName) {
        this.endPointByIdOrName = endPointByIdOrName;
    }

   public static Performable searchByIdOrName(String endPointByIdOrName){
        return instrumented(GetSingleAbility.class,endPointByIdOrName);
   }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PokeApiResources.SINGLE_ABILITY_RESOURCE.getValue())
                        .with(
                                searchType -> searchType.pathParam("IdOrName", endPointByIdOrName )

                        ).with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );
    }
}
