package com.alkosto.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BackPage implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
                BrowseTheWeb.as(actor).getDriver().navigate().back();
    }

    public static BackPage backPage(){
        return instrumented(BackPage.class);
    }
}
