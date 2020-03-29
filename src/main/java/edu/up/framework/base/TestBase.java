package edu.up.framework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/*
This class would be used as test base class for the test classes
 */
public abstract class TestBase {
    public DriverManager driverManager;
    public WebDriver driver;

    @BeforeClass
    public void beforeClass(){
    }

    @BeforeTest
    public void beforeEachTest(){

        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void  afterMethod(){
        driverManager.quitDriver();
    }

    @AfterTest
    public void afterEachTest(){

    }

    @AfterClass
    public void afterClass(){

    }
}
