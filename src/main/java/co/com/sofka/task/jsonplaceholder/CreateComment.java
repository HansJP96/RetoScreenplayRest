package co.com.sofka.task.jsonplaceholder;

import co.com.sofka.models.jsonplaceholder.CommentsModel;
import co.com.sofka.util.JsonPlaceHolderResources;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;


import java.nio.charset.StandardCharsets;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateComment implements Task {

    private final CommentsModel newData;

    public CreateComment(CommentsModel newData) {
        this.newData = newData;
    }

    public static Performable typeOnPostCommentData(CommentsModel newData){
        return instrumented(CreateComment.class,newData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(JsonPlaceHolderResources.CREATE_COMMENT.getValue())
                        .with(requestSpecification ->
                                requestSpecification.contentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8))
                                        .body(newData.toJson())
                        )
        );
    }
}
