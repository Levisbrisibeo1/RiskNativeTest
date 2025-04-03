package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Set path to chromedriver inside resources 
            String path = System.getProperty("user.dir") + "/src/test/resources/ChromeDriver/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", path);

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
