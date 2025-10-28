package com.questions;

import com.userInterface.ValidacionDespachoProductosQuimicos;
import com.userInterface.ValidacionRecepcionProductosQuimicos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.LocalDate;

public class ValidacionCantidadDespachoProductosQuimicos implements Question {
    @Override
    public Object answeredBy(Actor actor) {

        LocalDate hoy = LocalDate.now();
        int numeroDiaHoy = hoy.getDayOfMonth();
        String numeroDiaHoyString = String.valueOf(numeroDiaHoy);

        String validacion = ValidacionDespachoProductosQuimicos.CANTIDAD_QUIMICO_KILOS_ENTREGADOS.of(numeroDiaHoyString).resolveFor(actor).getText();
        return null;
    }

    public static Question cantidadEntregada(){
        return new ValidacionCantidadDespachoProductosQuimicos() ;
    }
}
