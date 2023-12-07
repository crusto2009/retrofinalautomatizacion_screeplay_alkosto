package com.alkosto.task;

import com.alkosto.questions.ValidationVisibleCookiesBtn;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.alkosto.UI.HomeUI.BTN_COOKIES;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClicBtnCookieTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean isVisible =  actor.asksFor(ValidationVisibleCookiesBtn.validateCookie());
        if(isVisible){
            actor.attemptsTo(
                    Click.on(BTN_COOKIES)
            );
        }
    }

    public static ClicBtnCookieTask clickCookieBtn(){
        return instrumented(ClicBtnCookieTask.class);
    }
}
