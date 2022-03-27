package co.com.sofka.runners.jsonplaceholder;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;

import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/jsonplaceholder/comments.feature"},
        glue = {"co.com.sofka.stepdefinition.jsonplaceholder"}
)
public class CommentsTest {
}
