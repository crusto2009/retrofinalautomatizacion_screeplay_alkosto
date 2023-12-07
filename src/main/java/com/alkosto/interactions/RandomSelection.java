package com.alkosto.interactions;

import com.alkosto.models.Product;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import java.util.List;
import java.util.Random;

import static com.alkosto.UI.ListProductsUI.LIST_PRODUCTS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RandomSelection implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

            List<WebElementFacade> listSongs = LIST_PRODUCTS.resolveAllFor(actor);
            Random random = new Random();
            int indexRandom = random.nextInt(listSongs.size());
            Product.addTitle(listSongs.get(indexRandom).getText());
            listSongs.get(indexRandom).click();
    }

    public static RandomSelection click(){
        return instrumented(RandomSelection.class);
    }
}
