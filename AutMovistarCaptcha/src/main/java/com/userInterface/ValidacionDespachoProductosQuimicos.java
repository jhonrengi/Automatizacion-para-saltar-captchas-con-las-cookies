package com.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidacionDespachoProductosQuimicos {

    public static final Target CANTIDAD_QUIMICO_KILOS_ENTREGADOS = Target.the("Contine la cantidad de kilos entregados por despacho")
            .located(By.xpath("//tr[td[text()='6:00 - 18:00'] and td[text()='{0}']]/td[9]"));

    public static final Target MENSAJE_CANTIDAD_REGISTRADA = Target.the("Mensaje que informa que el registro fue exitoso")
            .located(By.xpath("//span[contains(text(), 'La información se ha almacenado exitosamente.')]"));
}
