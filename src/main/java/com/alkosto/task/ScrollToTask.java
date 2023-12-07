package com.alkosto.task;

import com.alkosto.interactions.ScrollTopPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollToTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ScrollTopPage.scrollTo()
        );
    }

    public static ScrollToTask scrollToPage(){
        return instrumented(ScrollToTask.class);
    }
}
