package edu.up.framework.base;

public class DriverManagerFactory {

    public  static  DriverManager getManager(DriverType type){
        System.out.println("Message: Inside DriverManager method from DriverManagerFactory");
        DriverManager driverManager;

        switch (type){
            case CHROME:
                System.out.println("Action: New chrome driver");
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                System.out.println("Action: New ff driver");
                driverManager = new FirefoxDriverManager();
                break;
            case EDGE:
                System.out.println("Action: New safari river");
                driverManager = new SafariDriverManager();
                break;
            default:
                System.out.println("Action: New edge driver");
                driverManager = new EdgeDriverManager();
                break;
        }
        return  driverManager;
    }
}
