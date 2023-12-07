package com.alkosto.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.alkosto.UI.HomeUI.BTN_SEARCH;
import static com.alkosto.UI.HomeUI.INPUT_SEARCH;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchProductTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(INPUT_SEARCH),
                Enter.theValue("Portatil").into(INPUT_SEARCH).thenHit(Keys.RETURN)
        );
    }

    public static SearchProductTask search(){
        return instrumented(SearchProductTask.class);
    }
}
