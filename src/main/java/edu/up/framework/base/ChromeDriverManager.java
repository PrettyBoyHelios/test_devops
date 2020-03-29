package edu.up.framework.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.rmi.server.ExportException;
import java.util.Objects;

import static edu.up.framework.base.WebDriverBySystem.*;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chromeDriverService;

    @Override
    protected void startService() {
        if(null== chromeDriverService){
            try{
                 chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(Objects.requireNonNull(getWebDriverFile())))
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
