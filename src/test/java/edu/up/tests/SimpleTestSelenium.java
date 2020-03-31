package edu.up.tests;

import edu.up.framework.base.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SimpleTestSelenium {

    @Test (groups = {"Basic"})
    public void ShouldOpenBrowser() {
        WebDriver driver = WebDriverFactory.getWebDriver();
        driver.navigate().to("https://www.up.edu.mx/es");
        driver.quit();
    }

    @Test (groups = {"Basic", "Incomplete"})
    public void shouldReturnNumberOfLinks(){
        /* TODO */
        /*Add code to obtain the number of links and print to console*/

    }
}


