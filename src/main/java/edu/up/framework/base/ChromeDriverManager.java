package edu.up.framework.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.rmi.server.ExportException;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chromeDriverService;

    @Override
    protected void startService() {
        if(null== chromeDriverService){
            try{
                 chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(WebDriverBySystem.getWebDriverFile()))
                        .usingAnyFreePort()
                        .build();
                chromeDriverService.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (null != chromeDriverService  && chromeDriverService.isRunning())
            chromeDriverService.stop();
    }

    @Override
    protected void createService() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        driver = new ChromeDriver(chromeDriverService,options);
    }
}
