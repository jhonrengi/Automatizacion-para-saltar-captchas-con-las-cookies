package speed.stepsDefinitions;

import com.driver.CustomChromeDriver;
import com.interaction.NavigateTo;
import com.questions.ValidacionCantidadProductosQuimicos;
import com.questions.ValidacionCantidadRecepcionProductosQuimicos;
import com.questions.ValidacionDespacho;
import com.task.ConsumoProductosQuimicosTask;
import com.task.DespachoProductosQuimicosTask;
import com.task.OperacionPlantaTask;
import com.task.RecepcionProductosQuimicosTask;
import com.utils.Excel;
import com.utils.Hover;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ComsumoProductosQuimicos {

    private Actor testActor;
    private Hover hover;
    Excel excel = new Excel();

    @Managed
    WebDriver driver;

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }

    @Given("que el usuario se logea en la pagina Rop e ingresa a la opcion Consumo Productos Quimicos.")
    public void ingresoALaWeb() throws IOException {
        WebDriverManager.chromedriver().setup();
        CustomChromeDriver customDriver = new CustomChromeDriver();
        customDriver.initializeDriver();
        driver = customDriver.getDriver();
        testActor = Actor.named("Test").can(BrowseTheWeb.with(driver));
        testActor.attemptsTo(
                NavigateTo.someUrl(excel.leerDatosExcel("Data.xlsx","Hoja1",1,0)));
    }

    @Cuando("El usuario seleccione la fecha correspondiente, con el quimico asgindado y pueda edtiar el consumo del dia.")
    public void elUsuarioSeleccioneLaFechaCorrespondienteConElQuimicoAsgindadoYPuedaEdtiarElConsumoDelDia() throws IOException {

        testActor.attemptsTo(
                ConsumoProductosQuimicosTask.consumoProductosQuimicos(hover)
        );

       // Assert.assertEquals(ValidacionCantidadProductosQuimicos.cantidad(), excel.leerDatosExcel("Data.xlsx", "Hoja1", 1, 3));
    }
    @Entonces("El usuario puede visualizar un registro con la cantidad total calculada.")
    public void elUsuarioPuedeVisualizarUnRegistroConLaCantidadTotalCalculada() throws IOException {
       // Assert.assertEquals(ValidacionCantidadProductosQuimicos.cantidad(), excel.leerDatosExcel("Data.xlsx", "Hoja1", 1, 3));
        Ensure.that(ValidacionCantidadProductosQuimicos.cantidad()).isEqualTo(excel.leerDatosExcel("Data.xlsx", "Hoja1", 1, 3));

    }


    @Dado("que el usuario se logea en la pagina Rop e ingresa a la opcion Recepcion-Despacho Productos Quimicos.")
    public void queElUsuarioSeLogeaEnLaPaginaRopEIngresaALaOpcionRecepcionDespachoProductosQuimicos() throws IOException {
        WebDriverManager.chromedriver().setup();
        CustomChromeDriver customDriver = new CustomChromeDriver();
        customDriver.initializeDriver();
        driver = customDriver.getDriver();
        testActor = Actor.named("Test").can(BrowseTheWeb.with(driver));
        testActor.attemptsTo(
                NavigateTo.someUrl(excel.leerDatosExcel("Data.xlsx","Hoja1",1,0)));
    }

    @Cuando("El usuario seleccione una opcion nueva de recepcion, con el quimico asgindado, el proveedor y demas requisitos para la recepcion")
    public void elUsuarioSeleccioneUnaOpcionNuevaDeDespachoConElQuimicoAsgindadoElProveedorYDemasRequisitosParaLaRecepcion() {
        testActor.attemptsTo(
                RecepcionProductosQuimicosTask.recepcion(hover)
        );
    }

    @Entonces("El usuario puede visualizar el registro de la cantidad total recebida.")
    public void elUsuarioPuedeVisualizarElRegistroDeLaCantidadTotalRecebida() throws IOException {
        Ensure.that(ValidacionCantidadRecepcionProductosQuimicos.cantidadRecibida()).isEqualTo(excel.leerDatosExcel("Data.xlsx",  "Hoja2", 1, 1));
    }


    @Cuando("El usuario seleccione una opcion nueva de despacho, con el quimico asgindado, el proveedor y demas requisitos para el despacho")
    public void elUsuarioSeleccioneUnaOpcionNuevaDeDespachoConElQuimicoAsgindadoElProveedorYDemasRequisitosParaElDespacho() {
        testActor.attemptsTo(
                DespachoProductosQuimicosTask.despacho(hover)
        );
    }

    @Entonces("El usuario puede visualizar el registro de la cantidad total entregada.")
    public void elUsuarioPuedeVisualizarElRegistroDeLaCantidadTotalEntregada() throws IOException {
        //Ensure.that(ValidacionCantidadProductosQuimicos.cantidad()).isEqualTo(excel.leerDatosExcel("Data.xlsx", "Hoja1", 1, 3));
        testActor.should(
                seeThat(ValidacionDespacho.validacion(), Matchers.equalTo(true))

        );
    }

}
