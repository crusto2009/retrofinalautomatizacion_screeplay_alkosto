package com.alkosto.UI;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductoViewUI {
    public static final Target BTN_ADD_CARD = Target.the("Boton agregar carrito").
            located(By.xpath("//*[@id='addToCartButton']"));
    public static final Target BTN_CONTINUO_SHOPPING = Target.the("Boton continuar comprando")
            .located(By.xpath("//*[@class='continue-shopping-button']//a"));
    public static final Target BTN_GO_CARD = Target.the("Boton ir carrito compra").located(By.xpath("//a[contains(@class,'button-primary cart-pop-up-warrantyFooter_cartRedirect')]"));
}
