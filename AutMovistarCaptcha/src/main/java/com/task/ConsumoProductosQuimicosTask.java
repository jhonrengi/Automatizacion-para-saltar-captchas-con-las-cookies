package com.task;

import com.userInterface.ConsumoProductosQuimicosUI;
import com.userInterface.OperacionPlantaUI;
import com.utils.Excel;
import com.utils.Hover;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.LocalDate;

import static com.task.HoverOverElement.over;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsumoProductosQuimicosTask implements Task {
    Excel excel = new Excel();

    @Override
    public <T extends Actor> void performAs(T actor) {

        LocalDate hoy = LocalDate.now();
        int numeroDiaHoy = hoy.getDayOfMonth();
        String numeroDiaHoyString = String.valueOf(numeroDiaHoy);


        actor.attemptsTo(
                Click.on(OperacionPlantaUI.BOTON_INGRESAR),
                Click.on(OperacionPlantaUI.SELECCION_OPERACION),
                Click.on(OperacionPlantaUI.BOTON_ACEPTAROPERACION),
                Click.on(OperacionPlantaUI.SELECCION_PLANTA),
                Click.on(OperacionPlantaUI.BOTON_ACEPTARPLANTA),
                WaitUntil.the(OperacionPlantaUI.SELECCION_ADMINISTRADORES, isVisible()).forNoMoreThan(10).seconds(),
                over(By.xpath("//a[text()='Administradores']")),
                Click.on(ConsumoProductosQuimicosUI.BOTON_CONSUMO_PRODUCTOS_QUIMICOS),
                Click.on(ConsumoProductosQuimicosUI.SELECCION_QUIMICO),
                Click.on(ConsumoProductosQuimicosUI.BOTON_CONSULTAR),

                WaitUntil.the(ConsumoProductosQuimicosUI.BOTON_EDITAR.of(numeroDiaHoyString), isVisible()).forNoMoreThan(35).seconds(),
                Scroll.to(ConsumoProductosQuimicosUI.BOTON_EDITAR.of(numeroDiaHoyString)),
                Click.on(ConsumoProductosQuimicosUI.BOTON_EDITAR.of(numeroDiaHoyString)),
                WaitUntil.the(ConsumoProductosQuimicosUI.CAMPO_CONSUMO_BULTOS, isVisible()).forNoMoreThan(35).seconds(),
                Click.on(ConsumoProductosQuimicosUI.CAMPO_CONSUMO_BULTOS)

        );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            actor.attemptsTo(
                        Enter.theValue(excel.leerDatosExcel("Data.xlsx", "Hoja1", 1, 3)).into(ConsumoProductosQuimicosUI.CAMPO_CONSUMO_BULTOS),
                        WaitUntil.the(ConsumoProductosQuimicosUI.AREA_TEXTO, isVisible()).forNoMoreThan(35).seconds(),
                        Click.on(ConsumoProductosQuimicosUI.AREA_TEXTO),
                        Enter.theValue(excel.leerDatosExcel("Data.xlsx", "Hoja1", 1, 4)).into(ConsumoProductosQuimicosUI.AREA_TEXTO),
                        WaitUntil.the(ConsumoProductosQuimicosUI.BOTON_GUARDAR, isVisible()).forNoMoreThan(35).seconds(),
                        Scroll.to(ConsumoProductosQuimicosUI.BOTON_GUARDAR),
                        Click.on(ConsumoProductosQuimicosUI.BOTON_GUARDAR)

                );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //  String validacion = ConsumoProductosQuimicosUI.BOTON_GUARDAR.resolveFor(actor).getText();

        //Assert.assertEquals(validacion, "excel");


    }

    public static Performable consumoProductosQuimicos(Hover hover) {
        return instrumented(ConsumoProductosQuimicosTask.class, hover);
    }

}
