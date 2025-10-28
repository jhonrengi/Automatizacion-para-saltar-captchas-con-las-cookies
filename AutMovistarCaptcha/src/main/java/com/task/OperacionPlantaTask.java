package com.task;

import com.userInterface.OperacionPlantaUI;
import com.utils.Hover;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HoverOverElement;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import static com.task.HoverOverElement.over;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class OperacionPlantaTask implements Task {


    private Hover hover;

    public OperacionPlantaTask(Hover hover) {
        this.hover = hover;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OperacionPlantaUI.BOTON_INGRESAR),
                Click.on(OperacionPlantaUI.SELECCION_OPERACION),
                Click.on(OperacionPlantaUI.BOTON_ACEPTAROPERACION),
                Click.on(OperacionPlantaUI.SELECCION_PLANTA),
                Click.on(OperacionPlantaUI.BOTON_ACEPTARPLANTA),
                WaitUntil.the(OperacionPlantaUI.SELECCION_ADMINISTRADORES, isVisible()).forNoMoreThan(10).seconds(),
                over(By.xpath("//a[text()='Administradores']")),
                Click.on(OperacionPlantaUI.BOTON_OPERACIONPLANTA),
                Click.on(OperacionPlantaUI.BOTON_CALENDARIO),
                Click.on(OperacionPlantaUI.BOTON_ANO),
                Click.on(OperacionPlantaUI.BOTON_FLECHAANO),
                Click.on(OperacionPlantaUI.BOTON_MES),
                Click.on(OperacionPlantaUI.BOTON_DIA),
                Click.on(OperacionPlantaUI.BOTON_CONSULTAR)

        );

    }

    public static Performable operacionPlanta(Hover hover){
        return instrumented(OperacionPlantaTask.class,hover);
    }
}
