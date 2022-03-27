package co.com.sofka.question.jsonplaceholder;

import co.com.sofka.models.jsonplaceholder.CommentsModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CommentsResponse implements Question<CommentsModel> {

    public static CommentsResponse commentsResponse() {
        return new CommentsResponse();
    }

    @Override
    public CommentsModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(CommentsModel.class);
    }


}
