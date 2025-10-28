package com.driver;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.UnexpectedAlertBehaviour;

public class CustomChromeDriver {

    private org.openqa.selenium.chrome.ChromeDriver driver;

    public void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        String rutaProyecto = System.getProperty("user.dir");
        String ruta2 = rutaProyecto + "\\src\\main\\resources\\Default";
        options.addArguments("user-data-dir="+ruta2);
        driver = new org.openqa.selenium.chrome.ChromeDriver(service, options);
    }

    public org.openqa.selenium.chrome.ChromeDriver getDriver() {
        return driver;
    }
}
