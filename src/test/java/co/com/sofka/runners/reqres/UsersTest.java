package co.com.sofka.runners.reqres;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/reqres/users.feature"},
        glue = {"co.com.sofka.stepdefinition.reqres"}
)
public class UsersTest {
}
