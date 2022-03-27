package co.com.sofka.task.jsonplaceholder;

import co.com.sofka.models.jsonplaceholder.CommentsModel;
import co.com.sofka.util.JsonPlaceHolderResources;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.nio.charset.StandardCharsets;

public class UpdateComment implements Task {

    private  String endPointById;
    private  CommentsModel newData;

    public static  UpdateComment updateComment(){
        return new UpdateComment();
    }
    public  UpdateComment typeNewData(CommentsModel newData){
        this.newData= newData;
        return this;
    }

    public  UpdateComment andSendChangesToPostById(String endPointById){
        this.endPointById= endPointById;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(JsonPlaceHolderResources.UPDATE_COMMENT.getValue())
                        .with(idComment -> idComment.pathParam("id", endPointById)
                                .contentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8))
                                .body(newData.toJson())
                        )
        );
    }
}
