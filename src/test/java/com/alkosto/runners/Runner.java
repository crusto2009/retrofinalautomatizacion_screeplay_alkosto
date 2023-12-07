package com.alkosto.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.alkosto.stepDefinitions",
        tags = "@addProducts",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
