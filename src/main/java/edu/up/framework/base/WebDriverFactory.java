package edu.up.framework.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class WebDriverFactory {
    private final static Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
    private static String WINDOWS_DRIVER = "/chromedriver/windows/chromedriver.exe";
    private static String MAC_DRIVER = "/chromedriver/mac/chromedriver";
    private static final String LINUX_DRIVER = "/chromedriver/linux/chromedriver";

    private static int iPosX;
    private static int iPosY;

    public static WebDriver getWebDriver() {
        if (System.getProperty("os.name").contains("Mac")) {
            System.out.println("Mac OS detected");
            String sDriver =WebDriverFactory.class.getResource(MAC_DRIVER).getFile();
            System.setProperty("webdriver.chrome.driver",  urlDecode(sDriver) );
        }
        if (System.getProperty("os.name").contains("Linux")){
            System.out.println("Linux OS detected");
            String sDriver =WebDriverFactory.class.getResource(LINUX_DRIVER).getFile();
            System.setProperty("webdriver.chrome.driver", urlDecode(sDriver) );
        }
        else{
            System.out.println("Windows OS detected");
            String sDriver =WebDriverFactory.class.getResource(WINDOWS_DRIVER).getFile();
            System.setProperty("webdriver.chrome.driver", urlDecode(sDriver) );
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-extensions");
        WebDriver d = new ChromeDriver(options);
        positionBrowserWindow(d);
        return d;
    }

    private static void positionBrowserWindow(WebDriver driver){
        Random rn = new Random();
        iPosX = rn.nextInt(600 - 50 + 1) + 50;
        iPosY = rn.nextInt(100 - 10 + 1) + 40;
        driver.manage().window().setPosition(new Point(iPosX, iPosY));
        driver.manage().window().setSize(new Dimension(1000, 800));
    }

    private static String urlDecode(String value)  {
        try {
            return java.net.URLDecoder.decode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
