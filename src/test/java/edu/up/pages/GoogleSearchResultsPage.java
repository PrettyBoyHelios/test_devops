package edu.up.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchResultsPage {

    @FindBy(className = "rc")
    private List<WebElement> results;

    @Inject
    public GoogleSearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public int getCount(){
        return results.size();
    }

    public void displayResults(){
        results.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
    }
}
