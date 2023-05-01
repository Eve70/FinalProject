package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    protected WebDriver driver;

    private By userName = By.id("user-name");
    private By passWord = By.id("password");
    private By loginButton = By.id("login-button");
    private By pageTitle = By.className("login_logo");
    private By errorMessage = By.className("error-button");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void assertEqualPageTitles()  {
        new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.findElement(pageTitle).getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


    public void enterUsername(String username){
        driver.findElement(userName).sendKeys(username);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

    }

    public void enterPassword(String password) {
        driver.findElement(passWord).sendKeys(password);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
    }
        public void clickOnLoginButton () {
        driver.findElement(loginButton).click();
        }
    public void errorIsDisplayed(){
        driver.findElement(errorMessage).isDisplayed();
    }
    }

