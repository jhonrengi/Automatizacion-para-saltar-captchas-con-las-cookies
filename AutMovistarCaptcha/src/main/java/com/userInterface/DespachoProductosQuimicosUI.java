package com.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DespachoProductosQuimicosUI {

    public static final Target BOTON_DESPACHO = Target.the("Seleccion recepcion/despacho productos quimicos")
            .located(By.xpath("//a[@href='/Modulos/Administracion/General/AdministradorRecepcionQuimicos.aspx']"));

    public static final Target SELECCION_DESPACHO = Target.the("Seleccion despacho productos quimicos")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_rdbConsultaDespacho']"));

    public static final Target BOTON_NUEVO = Target.the("Boton Nuevo ")
            .located(By.xpath("//input[@value='Nuevo' and @name='ctl00$ContentPlaceHolder1$btnNuevoDespacho']"));

    public static final Target PLANTA_DESTINO = Target.the("Boton Nuevo ")
            .located(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlPlantaDestinoEdicionDespacho']/option[text()='Aguas Frías']"));
    public static final Target SELECCION_QUIMICO = Target.the("Seleccion quimico carbon activado")
            .located(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlQuimicoEdicionDespacho']/option[text()='Carbón activado']"));
    public static final Target CANTIDAD_DESPACHO = Target.the("Cantidad despachada")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtCantidadEdicionDespacho']"));
    public static final Target BOTON_GUARDAR = Target.the("Boton guardar")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnGuardarDespachoEdicion']"));






}
