package com.alkosto.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.alkosto.UI.ProductoViewUI.BTN_GO_CARD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToCardTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_GO_CARD)
        );
    }

    public static GoToCardTask goToCard(){
        return instrumented(GoToCardTask.class);
    }
}
