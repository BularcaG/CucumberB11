package stepdefinitions.webordersteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.weborderpages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginPageSteps {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);


    @Given("the user navigates to the WebOrder website")
    public void the_user_navigates_to_the_web_order_website() {

        driver.navigate().to(ConfigReader.readProperty("weborderurl"));


    }
    @When("the user provides credentials")
    public void the_user_provides_credentials() {
        loginPage.login(ConfigReader.readProperty("weborderusername"),ConfigReader.readProperty("weborderpassword"));
    }
    @Then("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        Assert.assertEquals(driver.getTitle(),"ORDER DETAILS - Weborder");
    }


    @When("the user provides correct username and wrong password")
    public void the_user_provides_correct_username_and_wrong_password() {
        loginPage.login(ConfigReader.readProperty("weborderusername"),"wrongpassword");
    }

    @Then("the user validates the {string} error message")
    public void the_user_validates_the_error_message(String expectedMessage) {
        Assert.assertTrue(loginPage.validateErrorMessage(expectedMessage));
    }


    @When("the user provides wrong username and wrong password") //harcoding
    public void the_user_provides_wrong_username_and_wrong_password() {
        loginPage.login("ahmet","baldir");
    }

    @When("the user provides wrong {string} and wrong {string}")
    public void the_user_provides_wrong_and_wrong(String username, String password) {
        loginPage.login(username, password);
    }

    @When("the user provides empty username and empty password")
    public void the_user_provides_empty_username_and_empty_password() {
    loginPage.login("","");
    }

}
