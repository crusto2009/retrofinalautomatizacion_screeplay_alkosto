package com.alkosto.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.alkosto.UI.ProductoViewUI.BTN_CONTINUO_SHOPPING;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ContinuosShoppingProductTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CONTINUO_SHOPPING)
        );
    }

    public  static ContinuosShoppingProductTask continuosShopping(){
        return instrumented(ContinuosShoppingProductTask.class);
    }
}
