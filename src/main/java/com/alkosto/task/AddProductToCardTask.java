package com.alkosto.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.alkosto.UI.ProductoViewUI.BTN_ADD_CARD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductToCardTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ADD_CARD)
        );
    }

    public static AddProductToCardTask addToCard(){
        return instrumented(AddProductToCardTask.class);
    }
}
