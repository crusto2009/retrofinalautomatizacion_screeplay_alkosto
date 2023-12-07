package com.alkosto.UI;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {

    public static final Target BTN_COOKIES = Target.the("boton cookies").located(By.xpath("//*[contains(@class,'js-cookie-notification-accept')]"));
    public static final Target INPUT_SEARCH = Target.the("input search").located(By.xpath("//input[@id='js-site-search-input']"));

    public static final Target BTN_SEARCH = Target.the("Boton buscar").locatedBy("//button[@type='submit'][1]");
}
