package com.alkosto.stepDefinitions;

import com.alkosto.questions.ValidationCard;
import com.alkosto.task.*;
import io.cucumber.java.*;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.annotations.events.AfterScenario;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;


import static com.alkosto.utils.ProcessID.getChromePID;
import static com.alkosto.utils.ProcessID.terminateLastChromeSubprocess;
import static com.alkosto.utils.TerminateProcess.terminateProcess;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class SeleccionarProductosStepDefinitions {


    @Managed(driver = "chrome")
    private WebDriver driver;


    Actor user = Actor.named("User");

    @Before
    public void setUp(){
        System.out.println("Inicio");
        WebDriverManager.chromedriver().setup();
        setTheStage(new OnlineCast());
        user.can(BrowseTheWeb.with(driver));
    }

    @BeforeScenario
    public void beforeScenario(){
        System.out.println("Antes de cada escenario");
    }

    @AfterScenario
    public void afterScenarios(){
        System.out.println("despues de cada escenario");
    }

    @After
    public void afterScenario() {
        // Limpieza después de cada escenario
        // Captura el PID de la última instancia de Chrome
        String pid = getChromePID();
        if (pid != null) {
            System.out.println("PID de la última instancia de Chrome: " + pid);

            // Termina el proceso utilizando el PID
            terminateProcess(pid);
        } else {
            System.out.println("No se pudo obtener el PID de Chrome.");
        }
        //terminateLastChromeSubprocess();
    }

    @Dado("que ingreso en la pagina de la tienda")
    public void queIngresoEnLaPaginaDeLaTienda() {
        user.wasAbleTo(
                OpenBrowserTask.open()
        );
    }
    @Cuando("de clic en un producto y lo agrege al carrito")
    public void deClicEnUnProductoYLoAgregeAlCarrito() {


        user.attemptsTo(
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
        user.should(
                seeThat(
                        ValidationCard.validate(),
                        Matchers.equalTo(true)
                )
        );
    }
}
