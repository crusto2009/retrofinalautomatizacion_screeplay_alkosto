package com.alkosto.UI;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ListProductsUI {

    public static final Target LIST_PRODUCTS = Target.the("lista de productos").
            located(By.xpath("//div[@class='product__item__top']//h3/a"));


}
