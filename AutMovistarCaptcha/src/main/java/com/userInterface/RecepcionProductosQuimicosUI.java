package com.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RecepcionProductosQuimicosUI {
    public static final Target BOTON_RECEPCION = Target.the("Seleccion recepcion/despacho productos quimicos")
            .located(By.xpath("//a[@href='/Modulos/Administracion/General/AdministradorRecepcionQuimicos.aspx']"));

    public static final Target BOTON_NUEVO = Target.the("Boton Nuevo ")
            .located(By.xpath("//input[@value='Nuevo' and @name='ctl00$ContentPlaceHolder1$btnNuevo']"));

    public static final Target SELECCION_PROVEEDOR = Target.the("Seleccion proveedor ")
            .located(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlProveedorEdicion'] /option[text()='PROTOQUIMICA SAS'] "));

    public static final Target SELECCION_QUIMICO = Target.the("Seleccion de quimico , carbon activado ")
            .located(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlQuimicoEdicion']/option[text()='Carbón activado'] "));
    public static final Target NUMERO_REMISION = Target.the("Asignar numero de remision")
            .located(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtNumeroRemision']"));

    public static final Target AUTORIZA_DESCARGA = Target.the("Check box autorizacion descarga")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_chkAutorizaDespacho']"));
    public static final Target CANTIDAD_RECIBIDA = Target.the("Cantidad Recibidad del quimico")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtCantidadEdicion']"));
    public static final Target BOTON_GUARDAR = Target.the("Boton Guardar")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnGuardar']"));



    public static final Target CALENDARIO = Target.the("Boton Consultar")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnFechaDesde']"));



    public static final Target BOTON_CONSULTAR = Target.the("Boton Consultar")
            .located(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnConsultar']"));







}
