package co.com.sofka.task.reqres;

import co.com.sofka.util.ReqResResources;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.nio.charset.StandardCharsets;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUser implements Task {
    private final Integer id;

    public DeleteUser(Integer id) {
        this.id = id;
    }

    public static Performable deleteUserById(Integer id) {
        return instrumented(DeleteUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(ReqResResources.DELETE_USER.getValue())
                        .with(requestSpecification ->
                                requestSpecification.pathParams("id", id)
                                        .contentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8))
                        )
        );
    }
}
