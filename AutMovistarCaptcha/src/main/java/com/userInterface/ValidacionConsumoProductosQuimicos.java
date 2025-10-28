package com.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidacionConsumoProductosQuimicos {


    public static final Target CANTIDAD_QUIMICO_BULTOS = Target.the("Contine la cantidad de bultos consumidos")
            .located(By.xpath("//tr[td[text()='6:00 - 18:00'] and td[text()='{0}']]/td[10]"));

    public static final Target CANTIDAD_QUIMICO_BULTOS_KILOS = Target.the("Contine la cantidad de kilos consumidos")
            .located(By.xpath("//tr[td[text()='6:00 - 18:00'] and td[text()='{0}']]/td[11]"));



}
