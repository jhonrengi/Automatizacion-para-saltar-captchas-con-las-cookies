package com.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OperacionPlantaUI {

    public static final Target BOTON_INGRESAR = Target.the("Boton logearse")
            .located(By.xpath("//input[@class='FormBotonPrincipal']"));

    public static final Target SELECCION_OPERACION = Target.the("Seleccionar operacion")
            .located(By.xpath("//select[@id='ddlProceso']/option[@value='1']"));

    public static final Target BOTON_ACEPTAROPERACION = Target.the("Boton aceptar operacion")
            .located(By.xpath("//input[@id='btnAceptarProceso']"));


    public static final Target SELECCION_PLANTA = Target.the("Seleccion de planta")
            .located(By.xpath("//select[@id='DdlPlanta']/option[@value='1']"));


    public static final Target BOTON_ACEPTARPLANTA = Target.the("Boton aceptar planta")
            .located(By.xpath("//input[@id='BtnAceptar']"));


    public static final Target SELECCION_ADMINISTRADORES = Target.the("Seleccion Administradores")
            .located(By.xpath("//a[text()='Administradores']"));

    public static final Target BOTON_OPERACIONPLANTA = Target.the("Seleccion operacion planta")
            .located(By.xpath("//a[@href='/Modulos/Administracion/Potabilizacion/AdministradorOperacionPlanta.aspx']"));


    public static final Target BOTON_CALENDARIO = Target.the("Acceder al calendario")
            .located(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$BtnFecha']"));

    public static final Target BOTON_ANO = Target.the("Seleccion de año")
            .located(By.xpath("//div[@id='CEFechaInicial_title']"));

    public static final Target BOTON_FLECHAANO = Target.the("Flecha para seleccionar el año 2023")
            .located(By.xpath("//div[@id='CEFechaInicial_prevArrow']"));

    public static final Target BOTON_MES = Target.the("Seleccion fecha marzo 2023")
            .located(By.xpath("//div[contains(text(), 'Mar')]"));

    public static final Target BOTON_DIA = Target.the("Seleccion fecha 01 de marzo 2023")
            .located(By.xpath("//div[contains(text(), '1')]"));

    public static final Target BOTON_CONSULTAR = Target.the("Se consulta la fecha escogida")
            .located(By.xpath("//input[@value='Consultar']"));





}
