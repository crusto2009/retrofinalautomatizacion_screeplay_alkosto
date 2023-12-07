package com.alkosto.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.List;
import static com.alkosto.UI.CardShoppingUI.ITEMS_IN_CARD;
import static com.alkosto.models.Product.titleProducts;

public class ValidationCard implements Question {
    @Override
    public Object answeredBy(Actor actor) {

        List<WebElementFacade> listTitleProducts = ITEMS_IN_CARD.resolveAllFor(actor);

        if(titleProducts.contains(listTitleProducts.get(0).getText()) && titleProducts.contains(listTitleProducts.get(1).getText()) ){
            return true;
        }

        return false;
    }

    public static Question validate(){
        return new ValidationCard();
    }
}
