package com.alkosto.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import static com.alkosto.UI.HomeUI.BTN_COOKIES;

public class ValidationVisibleCookiesBtn implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return  Visibility.of(BTN_COOKIES).answeredBy(actor);
    }

    public static ValidationVisibleCookiesBtn validateCookie(){
        return new ValidationVisibleCookiesBtn();
    }
}
