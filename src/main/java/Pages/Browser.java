package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class Browser {
    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    public Browser (WebDriver driver){
        drivers= (Map<String, WebDriver>) driver;
    }

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;

      switch (browserName) {
          case "Chrome":
              driver = drivers.get("Chrome");
              if (driver == null) {
                  System.setProperty("webdriver.chrome.driver", "C://Users//Evi//Desktop//Selenium//Chromedriver//chromedriver.exe");
                  driver = new ChromeDriver();
                  drivers.put("Chrome", driver);
              }
              break;
      }
        return driver;
    }

    public static void closeAllDrivers() {
        for (String key : drivers.keySet()) {
            drivers.get(key).close();
            drivers.get(key).quit();
        }
    }
}
