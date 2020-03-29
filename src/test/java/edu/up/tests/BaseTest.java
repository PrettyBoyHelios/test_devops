package edu.up.tests;

import com.google.inject.Inject;
import edu.up.framework.base.DriverManager;
import org.testng.annotations.*;

public abstract class BaseTest {

    @Inject
    DriverManager driverManager;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Level 0 - The annotated method will be run before all tests in this suite have run");
    }

    @BeforeTest
    public void beforeTests(){
        System.out.println("Level 1 - The annotated method will be run before any test method belonging to the " +
                "classes inside the <test> tag is run");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Level 2 - The annotated method will be run before the first test method in the current " +
                "class is invoke");
    }

    @BeforeMethod
    public void beforeTestMethod(){
        System.out.println("Level 3 - The annotated method will be run before each test method");
    }

    @AfterMethod
    public void afterTestMethod(){
        System.out.println("Level 3 - The annotated method will be run after each test method.");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Level 2 - The annotated method will be run after all the test methods in the current " +
                "class have been run.");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Level 1 - The annotated method will be run after all the test methods belonging to the classes " +
                "inside the <test> tag have run");
        driverManager.quitDriver();
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println(" Level 0 - The annotated method will be run after all tests in this suite have run");
        if(null!=driverManager)  driverManager.quitDriver();
    }
}
