package edu.up.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    @FindBy(name ="q")
    WebElement searchTextBox;

    @FindBy(name="btnG")
    WebElement searchButton;

    //Injection of Web Driver
    @Inject
    public GoogleSearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void searchFor(String sentence){
        searchTextBox.sendKeys(sentence);
        searchButton.click();
    }
}
