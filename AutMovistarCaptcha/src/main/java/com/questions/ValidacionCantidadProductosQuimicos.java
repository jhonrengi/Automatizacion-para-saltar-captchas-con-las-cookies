package com.questions;

import com.userInterface.ValidacionConsumoProductosQuimicos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ValidacionCantidadProductosQuimicos implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {

        LocalDate hoy = LocalDate.now();
        int numeroDiaHoy = hoy.getDayOfMonth();
        String numeroDiaHoyString = String.valueOf(numeroDiaHoy);

        System.out.println("Iniciando la validación de la cantidad...");
        String resultado = ValidacionConsumoProductosQuimicos.CANTIDAD_QUIMICO_BULTOS.of(numeroDiaHoyString).resolveFor(actor).getText();
        int cantidadEntera = (int) Double.parseDouble(resultado);

        String validacion = String.valueOf(cantidadEntera);

        System.out.println("la validacion es"+validacion);

        return validacion;
    }

    public static Question<String> cantidad(){
        return new ValidacionCantidadProductosQuimicos() ;
    }
}
