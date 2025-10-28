package com.interaction;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;

public class NavigateTo implements Performable {
    private final String url;

    public NavigateTo(String url) {
        this.url = url;
    }

    public static NavigateTo someUrl(String url) {
        return new NavigateTo(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}