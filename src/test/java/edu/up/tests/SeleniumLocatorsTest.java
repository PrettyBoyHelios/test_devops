package edu.up.tests;


import edu.up.framework.base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SeleniumLocatorsTest extends TestBase {

    @Test (description = "Should math the number of links for top central section")
    @Description("Validation of the number of top section links")
    public void ShouldCountTopLinksTest(){
        // arrange
        driver.navigate().to("https://www.tesla.com");
        // act
        List<WebElement> list = driver.findElements(By.cssSelector("a[class='tds-header-nav--list_link']"));
        List<WebElement> links = list
                .stream()
                .filter(ele->ele.isDisplayed()==true)
                .collect(Collectors.toList());
        // assert
        Assert.assertEquals(7,links.size());
        printList(links);
    }

    @Test ( description = "Should select Model 3 for additional details")
    @Description("Model 3 car selection")
    public void ShouldSelectModel3() {
        // arrange
        driver.navigate().to("https://www.tesla.com");
        // act
        List<WebElement> list = driver.findElements(By.cssSelector("a[class='tds-header-nav--list_link']"));
        WebElement link = list
                .stream()
                .filter(ele->ele.isDisplayed()==true)
                .filter(ele->ele.getText().toUpperCase().contains("MODEL 3"))
                .findFirst()
                .orElse(null);
        if(null!=link) link.click();
        // assert
        WebDriverWait driverWait = new WebDriverWait(driver, 15);
        Boolean title = driverWait.until(ExpectedConditions.titleIs("Model 3 | Tesla"));
        Assert.assertTrue(title);

    }

    private void printList(List<WebElement> listWebElement){
        for(WebElement element : listWebElement){
            System.out.println(element.getText());
        }
    }
}
