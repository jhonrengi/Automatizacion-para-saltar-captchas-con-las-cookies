package com.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConsumoProductosQuimicosUI {

    public static final Target BOTON_CONSUMO_PRODUCTOS_QUIMICOS = Target.the("Seleccion Consumo Pruductos Quimicos")
            .located(By.xpath("//a[@href='/Modulos/Administracion/General/AdministradorConsumosQuimicos.aspx']"));


    public static final Target SELECCION_QUIMICO = Target.the("Seleccion Quimico Carbon activado")
            .located(By.xpath("//option[contains(text(), 'Carbón activado')]"));

    public static final Target BOTON_CONSULTAR= Target.the("Boton consultar  ")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_BtnConsultar']"));

    public static final Target BOTON_EDITAR= Target.the("Boton editar segun el turno  ")
            .locatedBy("//tr[td[text()='6:00 - 18:00'] and td[text()='{0}']]//a[text()='Editar']");

    public static final Target CAMPO_CONSUMO_BULTOS= Target.the("Campo de texto consumo de bultos ")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_UcAdministradorConsumoQuimicoSolido_FvConsumosQuimicosSolido_Consumo']"));

    //XPATH para el caso que el valor del comsumo sea en cantidad de kilos
    public static final Target CAMPO_CONSUMO_BULTOS_KILOS= Target.the("Campo de texto consumo de bultos ")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_UcAdministradorConsumoQuimicoSolido_FvConsumosQuimicosSolido_ConsumoKilos']"));


    public static final Target BOTON_GUARDAR= Target.the("Boton Guardar  ")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_UcAdministradorConsumoQuimicoSolido_FvConsumosQuimicosSolido_BtnGuardar']"));

    public static final Target AREA_TEXTO= Target.the("Campo de texto Observaciones ")
            .located(By.xpath("//textarea[@id='ctl00_ContentPlaceHolder1_UcAdministradorConsumoQuimicoSolido_FvConsumosQuimicosSolido_txtObservaciones']"));





}
