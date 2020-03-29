package edu.up.tests;

import com.google.inject.Inject;
import edu.up.framework.dependencyinjection.DriverModule;
import edu.up.pages.GooglePage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.List;

@Guice(modules ={DriverModule.class})

public class GoogleLocatorsTest extends BaseTest{

    @Inject
    GooglePage googlePage;


    @Test (groups = {"Basic"}, description = "Should perform a simple search")
    @Description("Should get results from search")
    public void shouldGetResultsFromSearchTest(){
        // arrange
        googlePage.goTo();
        // act
        googlePage.execute("document.body.style.backgroundColor='blue';");
        googlePage.getGoogleSearchPage().searchFor("Learning Java");
        googlePage.getGoogleSearchResultsPage().displayResults();
        // assert
        Assert.assertTrue(googlePage.getGoogleSearchResultsPage().getCount()>0);
    }

    @Test (groups = {"Basic"}, description = "Should perform a simple search")
    @Description("Should get results from search")
    public void shouldGetResultsFromSearch2Test(){
        // arrange
        googlePage.goTo();
        // act
        googlePage.execute("document.body.style.backgroundColor='green';");
        googlePage.getGoogleSearchPage().searchFor("Selenium WebDriver");
        googlePage.getGoogleSearchResultsPage().displayResults();
        // assert
        Assert.assertTrue(googlePage.getGoogleSearchResultsPage().getCount()>0);
    }

    private void printList(List<WebElement> listWebElement){
        for(WebElement element : listWebElement){
            System.out.println(element.getText());
        }
    }
}
