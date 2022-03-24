package co.com.sofka.runners.pokeapi;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/pokeapi/singleAbility.feature"},
        glue = {"co.com.sofka.stepdefinition.pokeapi"}
)
public class SingleAbilityTest {
}
