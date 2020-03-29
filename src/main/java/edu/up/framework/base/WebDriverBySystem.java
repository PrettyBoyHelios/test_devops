package edu.up.framework.base;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class WebDriverBySystem {
    private static String WINDOWS_DRIVER = "/chromedriver/windows/chromedriver.exe";
    private static String MAC_DRIVER = "/chromedriver/mac/chromedriver";

    public static String getWebDriverFile() {
        if (System.getProperty("os.name").contains("Mac")) {
            File cDriver = new File(WebDriverBySystem.class.getResource(MAC_DRIVER).getFile());

            // Is it executable
            if (!cDriver.canExecute()) {
                cDriver.setExecutable(true);
            }
            System.setProperty("webdriver.chrome.driver", WebDriverBySystem.class.getResource(MAC_DRIVER).getFile());

            // Now checking for existence of Chrome executable.'
            if (!new File("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome").exists()) {
                throw new RuntimeException();
            }
            return WebDriverBySystem.class.getResource(MAC_DRIVER).getFile();
        }
        if (System.getProperty("os.name").contains("Linux")){
            /*
            TODO
             Implement code for linux OS
            */
        }
        if (System.getProperty("os.name").contains("Windows")){
            String sDriver =WebDriverBySystem.class.getResource(WINDOWS_DRIVER).getFile();
            System.setProperty("webdriver.chrome.driver", urlDecode(sDriver) );
            return WebDriverBySystem.class.getResource(WINDOWS_DRIVER).getFile();
        }
        return null;
    }

    private static String urlDecode(String value)  {
        try {
            return java.net.URLDecoder.decode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
