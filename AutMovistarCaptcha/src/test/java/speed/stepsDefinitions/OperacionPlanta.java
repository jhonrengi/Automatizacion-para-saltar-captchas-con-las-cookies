package speed.stepsDefinitions;


import com.driver.CustomChromeDriver;
import com.interaction.NavigateTo;
import com.task.OperacionPlantaTask;
import com.utils.Excel;
import com.utils.Hover;
import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class OperacionPlanta {

    private Actor testActor;
    private Hover hover;
    Excel excel = new Excel();

    @Managed
    WebDriver driver;

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());

    }
    @Given("que el usuario se logea en la pagina Rop e ingresa a la opcion operacion planta.")
    public void ingresoALaWeb() throws IOException {
        WebDriverManager.chromedriver().setup();
        CustomChromeDriver customDriver = new CustomChromeDriver();
        customDriver.initializeDriver();
        driver = customDriver.getDriver();
        testActor = Actor.named("Test").can(BrowseTheWeb.with(driver));
        testActor.attemptsTo(
                NavigateTo.someUrl(excel.leerDatosExcel("Data.xlsx","Hoja1",1,0)));
    }

    @When("El usuario edita el registro en el horario correspondiente")
    public void meEsteRegistrando()  {
        testActor.attemptsTo(
                OperacionPlantaTask.operacionPlanta(hover)
        );
    }

    @Then("El usuario puede visualizar el registro dentro del rango metas operativas.")
    public void quieroValidarQueEsteDentro() {

    }
}