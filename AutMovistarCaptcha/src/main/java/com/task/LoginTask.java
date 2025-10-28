package com.task;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.userInterface.LoginUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {


        WebElement element = BrowseTheWeb.as(actor).getDriver().findElement(By.xpath("ID_OF_ELEMENT"));


        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();

        js.executeScript("arguments[0].removeAttribute('readonly')", element);

        actor.attemptsTo(

      //     WaitUntil.the(TXT_LABEL, isVisible()).forNoMoreThan(150).seconds(),
                //     Click.on(BTN_INICIAR_SESION)

        );

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Performable on() {
        return Instrumented.instanceOf(LoginTask.class).withProperties();
    }
}
