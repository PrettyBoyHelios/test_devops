package edu.up.framework.dependencyinjection;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import edu.up.framework.base.ChromeDriverManager;
import edu.up.framework.base.DriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DriverManager.class)
                .to(ChromeDriverManager.class)
                .in(Scopes.SINGLETON);

        //reading from property file
        try{
        Properties properties = new Properties();
        properties.load(new FileInputStream("qa.properties"));
            Names.bindProperties(binder(),properties);
        }catch (IOException e){
            //skip
        }
    }

    @Provides
    public WebDriver getDriver(DriverManager driverManager){
        return driverManager.getDriver();
    }

    @Provides
    public Actions getActions(WebDriver driver){
        return  new Actions(driver);
    }

    @Provides
    public JavascriptExecutor getJsExecutor(WebDriver driver){
        return  (JavascriptExecutor)(driver);
    }
}
