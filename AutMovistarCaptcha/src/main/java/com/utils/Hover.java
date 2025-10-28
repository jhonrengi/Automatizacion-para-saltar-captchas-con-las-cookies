package com.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.core.Serenity.getDriver;

public class Hover {
    public void hoverElement(Target target, Actor actor) {
        WebElementFacade element = target.resolveFor(actor);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }
}
