package com.alkosto.task;

import com.alkosto.interactions.BackPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BackPageTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                BackPage.backPage()
        );
    }
    public static BackPageTask navigateBack(){
        return instrumented(BackPageTask.class);
    }
}
