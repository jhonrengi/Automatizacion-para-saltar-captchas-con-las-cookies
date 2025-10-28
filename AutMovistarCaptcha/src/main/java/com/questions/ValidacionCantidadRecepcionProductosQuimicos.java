package com.questions;

import com.userInterface.ValidacionConsumoProductosQuimicos;
import com.userInterface.ValidacionRecepcionProductosQuimicos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.LocalDate;

public class ValidacionCantidadRecepcionProductosQuimicos implements Question<String>  {
    @Override
    public String answeredBy(Actor actor) {
        LocalDate hoy = LocalDate.now();
        int numeroDiaHoy = hoy.getDayOfMonth();
        String numeroDiaHoyString = String.valueOf(numeroDiaHoy);

        String resultado = ValidacionRecepcionProductosQuimicos.CANTIDAD_QUIMICO_RECIBIDOS.resolveFor(actor).getText();
        int cantidadEntera = (int) Double.parseDouble(resultado);

        String validacion = String.valueOf(cantidadEntera);
        return validacion;
    }

    public static Question<String> cantidadRecibida(){
        return new ValidacionCantidadRecepcionProductosQuimicos() ;
    }
}
