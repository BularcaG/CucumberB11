package stepdefinitions.webordersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.weborderpages.CreateGroupOrderPage;
import pages.weborderpages.LoginPage;
import pages.weborderpages.OrderPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class OrderSteps {

    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginpage=new LoginPage(driver);
    OrderPage orderpage= new OrderPage(driver);
    CreateGroupOrderPage createOrderPage= new CreateGroupOrderPage(driver);


    @Given("the user is on weborder homepage")
    public void the_user_is_on_weborder_homepage() {

        driver.get(ConfigReader.readProperty("weborderurl"));
        loginpage.login(ConfigReader.readProperty("weborderusername"),ConfigReader.readProperty("weborderpassword"));
    }
    @When("the user selects {string} options")
    public void the_user_selects_options(String deliveryOption) {
        orderpage.getDeliveryoption(deliveryOption);

    }
    @When("the user is on the groupOrderPage")
    public void the_user_is_on_the_group_order_page() {
        orderpage.clickGroupOrder();
        orderpage.clickNextButton();
        Assert.assertEquals(driver.getTitle(),"Create Group Order - Weborder");
    }
    @When("the user sends invite note {string}")
    public void the_user_sends_invite_note(String invitenote) {
        createOrderPage.sendInviteNote(invitenote);

    }
    @When("the user sends invite list {string} and {string}")
    public void the_user_sends_invite_list_and(String email1, String email2) {
     createOrderPage.sendInviteList(email1+","+email2);
    }
    @Then("the user validates the {string} address")
    public void the_user_validates_the_address(String expectedaddress) {
        Assert.assertTrue(createOrderPage.getOfficeAddress().contains(expectedaddress) );

    }
    @Then("the user validates {string} text")
    public void the_user_validates_text(String expectedText) throws InterruptedException {
    createOrderPage.clickCreateGroupButton();
    Assert.assertEquals(createOrderPage.getHeaderText(),expectedText);

    }
    @Then("the user validates total participants is {int}")
    public void the_user_validates_total_participants_is(int expectedParticipants) {
        Assert.assertEquals(createOrderPage.getParticipants(),expectedParticipants);
    }

}
