package com.alkosto.stepDefinitions;

import com.alkosto.models.Product;
import com.alkosto.questions.ValidationCard;
import com.alkosto.task.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;

import org.hamcrest.Matchers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import static com.alkosto.UI.HomeUI.BTN_COOKIES;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class SeleccionarProductosStepDefinitions {


    @Managed(driver = "chrome")
    private WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        setTheStage(new OnlineCast());
        theActorCalled("user").can(BrowseTheWeb.with(driver));
    }

    @Dado("que ingreso en la pagina de la tienda")
    public void queIngresoEnLaPaginaDeLaTienda() {
        theActorInTheSpotlight().wasAbleTo(
                OpenBrowserTask.open()
        );
    }
    @Cuando("de clic en un producto y lo agrege al carrito")
    public void deClicEnUnProductoYLoAgregeAlCarrito() {


        theActorInTheSpotlight().attemptsTo(
                ClicBtnCookieTask.clickCookieBtn(),
                SearchProductTask.search(),
                SelectProductTask.selectRandom(),
                AddProductToCardTask.addToCard(),
                ContinuosShoppingProductTask.continuosShopping(),
                BackPageTask.navigateBack(),
                ScrollToTask.scrollToPage(),
                SelectProductTask.selectRandom(),
                AddProductToCardTask.addToCard(),
                GoToCardTask.goToCard()

        );
    }
    @Entonces("visualizo los productos que he seleccionado para comprar")
    public void visualizoLosProductosQueHeSeleccionadoParaComprar() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidationCard.validate(),
                        Matchers.equalTo(true)
                )
        );
    }
}
