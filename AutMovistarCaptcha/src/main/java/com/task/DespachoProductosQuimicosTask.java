package com.task;

import com.userInterface.ConsumoProductosQuimicosUI;
import com.userInterface.DespachoProductosQuimicosUI;
import com.userInterface.OperacionPlantaUI;
import com.userInterface.ValidacionDespachoProductosQuimicos;
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

public class DespachoProductosQuimicosTask implements Task {
    Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {
        LocalDate hoy = LocalDate.now();
        int numeroDiaHoy = hoy.getDayOfMonth();
        String numeroDiaHoyString = String.valueOf(numeroDiaHoy);
        try {
            actor.attemptsTo(
                    Click.on(OperacionPlantaUI.BOTON_INGRESAR),
                    Click.on(OperacionPlantaUI.SELECCION_OPERACION),
                    Click.on(OperacionPlantaUI.BOTON_ACEPTAROPERACION),
                    Click.on(OperacionPlantaUI.SELECCION_PLANTA),
                    Click.on(OperacionPlantaUI.BOTON_ACEPTARPLANTA),
                    WaitUntil.the(OperacionPlantaUI.SELECCION_ADMINISTRADORES, isVisible()).forNoMoreThan(10).seconds(),
                    over(By.xpath("//a[text()='Administradores']")),
                    Click.on(DespachoProductosQuimicosUI.BOTON_DESPACHO),
                    Click.on(DespachoProductosQuimicosUI.SELECCION_DESPACHO),
                    Click.on(DespachoProductosQuimicosUI.BOTON_NUEVO),
                    WaitUntil.the(DespachoProductosQuimicosUI.PLANTA_DESTINO, isVisible()).forNoMoreThan(35).seconds(),
                    Click.on(DespachoProductosQuimicosUI.PLANTA_DESTINO));
            Thread.sleep(20000);

            actor.attemptsTo(
                    WaitUntil.the(DespachoProductosQuimicosUI.SELECCION_QUIMICO, isVisible()).forNoMoreThan(35).seconds(),
                    Click.on(DespachoProductosQuimicosUI.SELECCION_QUIMICO));


            Thread.sleep(15000);
            actor.attemptsTo(
                    WaitUntil.the(DespachoProductosQuimicosUI.CANTIDAD_DESPACHO, isVisible()).forNoMoreThan(36).seconds(),
                    Click.on(DespachoProductosQuimicosUI.CANTIDAD_DESPACHO),
                    Enter.theValue(excel.leerDatosExcel("Data.xlsx", "Hoja3", 1, 0)).into(DespachoProductosQuimicosUI.CANTIDAD_DESPACHO));
            Thread.sleep(20000);
            actor.attemptsTo(
                    WaitUntil.the(DespachoProductosQuimicosUI.BOTON_GUARDAR, isVisible()).forNoMoreThan(35).seconds(),
                    Scroll.to(DespachoProductosQuimicosUI.BOTON_GUARDAR),
                    Click.on(DespachoProductosQuimicosUI.BOTON_GUARDAR));

            Thread.sleep(10000);
            /*
            actor.attemptsTo(
                    //WaitUntil.the(OperacionPlantaUI.SELECCION_ADMINISTRADORES, isVisible()).forNoMoreThan(10).seconds(),
                    Scroll.to(OperacionPlantaUI.SELECCION_ADMINISTRADORES),
                    over(By.xpath("//a[text()='Administradores']")),
                    Click.on(ConsumoProductosQuimicosUI.BOTON_CONSUMO_PRODUCTOS_QUIMICOS),
                    Click.on(ConsumoProductosQuimicosUI.SELECCION_QUIMICO),
                    Click.on(ConsumoProductosQuimicosUI.BOTON_CONSULTAR),
                    WaitUntil.the(ConsumoProductosQuimicosUI.BOTON_EDITAR.of(numeroDiaHoyString), isVisible()).forNoMoreThan(35).seconds()
                    //Scroll.to(ValidacionDespachoProductosQuimicos.CANTIDAD_QUIMICO_KILOS_ENTREGADOS)
            );

             */
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Performable despacho(Hover hover) {
        return instrumented(DespachoProductosQuimicosTask.class, hover);
    }
}
