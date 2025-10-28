package com.questions;

import com.userInterface.ValidacionDespachoProductosQuimicos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionDespacho implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return ValidacionDespachoProductosQuimicos.MENSAJE_CANTIDAD_REGISTRADA.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> validacion(){
        return new ValidacionDespacho();
    }
}
