package com.task;

import com.userInterface.*;
import com.utils.Excel;
import com.utils.Hover;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.LocalDate;

import static com.task.HoverOverElement.over;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RecepcionProductosQuimicosTask implements Task {
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
                Click.on(RecepcionProductosQuimicosUI.BOTON_RECEPCION),
                Click.on(RecepcionProductosQuimicosUI.BOTON_NUEVO),
                Click.on(RecepcionProductosQuimicosUI.SELECCION_PROVEEDOR));

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                    WaitUntil.the(RecepcionProductosQuimicosUI.SELECCION_QUIMICO, isVisible()).forNoMoreThan(50).seconds(),
                    Click.on(RecepcionProductosQuimicosUI.SELECCION_QUIMICO));
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            actor.attemptsTo(

                    WaitUntil.the(RecepcionProductosQuimicosUI.NUMERO_REMISION, isVisible()).forNoMoreThan(50).seconds(),
                    Click.on(RecepcionProductosQuimicosUI.NUMERO_REMISION),
                    Enter.theValue(excel.leerDatosExcel("Data.xlsx", "Hoja2", 1, 0)).into(RecepcionProductosQuimicosUI.NUMERO_REMISION),
                    Click.on(RecepcionProductosQuimicosUI.AUTORIZA_DESCARGA),
                    Click.on(RecepcionProductosQuimicosUI.CANTIDAD_RECIBIDA),
                    Enter.theValue(excel.leerDatosExcel("Data.xlsx", "Hoja2", 1, 1)).into(RecepcionProductosQuimicosUI.CANTIDAD_RECIBIDA),
                    Click.on(RecepcionProductosQuimicosUI.BOTON_GUARDAR)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


            actor.attemptsTo(
                    WaitUntil.the(OperacionPlantaUI.SELECCION_ADMINISTRADORES, isVisible()).forNoMoreThan(10).seconds(),
                    Scroll.to(OperacionPlantaUI.SELECCION_ADMINISTRADORES),
                    over(By.xpath("//a[text()='Administradores']")),
                    Click.on(ConsumoProductosQuimicosUI.BOTON_CONSUMO_PRODUCTOS_QUIMICOS),
                    Click.on(ConsumoProductosQuimicosUI.SELECCION_QUIMICO),
                    Click.on(ConsumoProductosQuimicosUI.BOTON_CONSULTAR),
                    WaitUntil.the(ConsumoProductosQuimicosUI.BOTON_EDITAR.of(numeroDiaHoyString), isVisible()).forNoMoreThan(35).seconds(),
                    Scroll.to(ConsumoProductosQuimicosUI.BOTON_EDITAR.of(numeroDiaHoyString))
                    //Scroll.to(ValidacionDespachoProductosQuimicos.CANTIDAD_QUIMICO_KILOS_ENTREGADOS)
            );





    }

    public static Performable recepcion(Hover hover) {
        return instrumented(RecepcionProductosQuimicosTask.class, hover);
    }
}
