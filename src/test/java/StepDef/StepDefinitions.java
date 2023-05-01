package StepDef;

import Pages.Browser;
import Pages.LoginPage;
import Pages.ProductListingPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {
    WebDriver driver=null;
    Browser browser;
    ProductListingPage PLP;
    LoginPage login;

    @Before
    public void before() throws InterruptedException {
        driver= Browser.getBrowser("Chrome");
        driver.manage().window().maximize();

    }
    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://www.saucedemo.com/");
        login = new LoginPage(driver);
        login.assertEqualPageTitles();
    }

    @When("user enters standard_user and secret_sauce")
    public void user_enters_standard_user_and_secret_sauce() {
        login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
    }

    @And("clicks on login button")
    public void clicks_on_login_button() throws InterruptedException {
        login = new LoginPage(driver);
        login.clickOnLoginButton();
    }

    @Then("products listing page is displayed")
    public void products_listing_page_is_displayed() throws InterruptedException {
        PLP = new ProductListingPage(driver);
        PLP.userIsOnPLP();
        System.out.println("User can login with valid credentials");
    }
    @When("user enters invalid locked_out_user and secret_sauce")
    public void user_enters_invalid_locked_out_user_and_secret_sauce() {
        login = new LoginPage(driver);
        login.enterUsername("locked_out_user");
        login.enterPassword("secret_sauce");
    }

    @Then("error is displayed")
    public void error_is_displayed() {
        login = new LoginPage(driver);
        login.errorIsDisplayed();
    }

    @When("user enters invalid made_up_user and secret_sauce")
    public void user_enters_invalid_made_up_user_and_secret_sauce() {
        login = new LoginPage(driver);
        login.enterUsername("made_up_user ");
        login.enterPassword("secret_sauce");
    }

    @After
    public void closeDrivers(){
        browser = new Browser(driver);
        browser.closeAllDrivers();
    }
}
