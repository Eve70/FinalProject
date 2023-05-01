package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {
    protected WebDriver driver;

    private By PLPProductContainer = By.id("inventory_container");
    public ProductListingPage (WebDriver driver){
        this.driver=driver;
    }

    public void userIsOnPLP() throws InterruptedException {
        driver.findElement(PLPProductContainer).isDisplayed();
    }

}