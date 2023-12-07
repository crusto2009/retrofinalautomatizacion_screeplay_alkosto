package com.alkosto.UI;

import net.serenitybdd.screenplay.targets.Target;

public class CardShoppingUI {

    public static final Target ITEMS_IN_CARD = Target.the("items en carrito").locatedBy("//*[@class='item__name']");
}
