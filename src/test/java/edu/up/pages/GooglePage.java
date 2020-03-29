package edu.up.pages;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class GooglePage {

    private final WebDriver driver;

    @Inject
    @Named("application.url")
    private String url;

    @Inject
    private GoogleSearchPage googleSearchPage;

    @Inject
    private GoogleSearchResultsPage googleSearchResultsPage;

    @Inject
    private Actions actions;

    @Inject
    private JavascriptExecutor javascriptExecutor;

    @Inject
    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(){
        this.driver.get(this.url);
    }

    public GoogleSearchPage getGoogleSearchPage(){
        return googleSearchPage;
    }

    public GoogleSearchResultsPage getGoogleSearchResultsPage() {
        return googleSearchResultsPage;
    }

    public void execute(String script) {
        // javascriptExecutor.executeScript(script); OR javascriptExecutor.executeAsyncScript(script);
        javascriptExecutor.executeScript(script);
    }
}
