package edu.up.tests;

import edu.up.framework.base.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class SimpleTestSelenium {

    @Test
    public void ShouldOpenBrowser() {
        WebDriver driver = WebDriverFactory.getWebDriver();
        driver.navigate().to("https://www.up.edu.mx/es");
        driver.close();
    }

    @Test
    public void shouldReturnNumberOfLinks(){
        /* TODO */
        /*Add code to obtain the number of links and print to console*/

    }
}
