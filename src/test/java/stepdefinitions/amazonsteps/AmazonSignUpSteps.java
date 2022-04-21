package stepdefinitions.amazonsteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.amazonpages.AmazonSignUpPage;
import utils.DriverHelper;

import java.util.List;

public class AmazonSignUpSteps {

    WebDriver driver= DriverHelper.getDriver();
    AmazonSignUpPage amazonSignUpPage=new AmazonSignUpPage(driver);



    @When("the user clicks the signIn and creates the amazon account button")
    public void the_user_clicks_the_sign_in_and_creates_the_amazon_account_button() {

    driver.navigate().to("https://www.amazon.com/");

    amazonSignUpPage.setCreateAccount();

    }
    @Then("the user validates the header")
    public void the_user_validates_the_header(DataTable dataTable) {

        List<String> header=dataTable.asList();
        Assert.assertEquals(header.get(0),amazonSignUpPage.getHeaderText());

    }
    @Then("the user provides the information:")
    public void the_user_provides_the_information(io.cucumber.datatable.DataTable dataTable) {

        List<String> allInformation=dataTable.asList();
        amazonSignUpPage.allInformation(allInformation.get(0), allInformation.get(1), allInformation.get(2), allInformation.get(3) );
    }

}
