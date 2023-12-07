package com.alkosto.task;

import com.alkosto.interactions.RandomSelection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectProductTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RandomSelection.click()
        );
    }

    public static SelectProductTask selectRandom(){
        return instrumented(SelectProductTask.class);
    }
}
