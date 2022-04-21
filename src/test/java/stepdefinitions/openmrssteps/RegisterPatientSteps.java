package stepdefinitions.openmrssteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.openmrspages.openMrsRegisterPage;
import pages.openmrspages.openmrsLoginpage;
import pages.openmrspages.openmrsmainpage;
import utils.DriverHelper;

import java.util.Map;

public class RegisterPatientSteps {
    WebDriver driver= DriverHelper.getDriver();
    openmrsLoginpage openmrsloginpage1 =new openmrsLoginpage(driver);
    openmrsmainpage openmrsmainPage=new openmrsmainpage(driver);
    openMrsRegisterPage openmrsRegisterpage=new openMrsRegisterPage(driver);

    @Given("a user logs in to OpenMrs with following credentials")
    public void a_user_logs_in_to_open_mrs_with_following_credentials(DataTable dataTable) {
      //  you should know that: dataTable will come as a parameter when you provide data table in
      // featrure file.And delete the first part of the Datatable and import it
    Map<String,String> usernamePasswordMap=dataTable.asMap();

         //username=admin
        // password=Admin123

//    String name=usernamePasswordMap.get("username");
//    String password=usernamePasswordMap.get("password");
//        System.out.println(name);//admin
//        System.out.println(password);//Admin123

        openmrsloginpage1.login(usernamePasswordMap.get("username"),usernamePasswordMap.get("password"));



    }
    @When("the user register a new pacient with following information:")
    public void the_user_register_a_new_pacient_with_following_information(DataTable dataTable) throws InterruptedException {

        Map<String,String> patientInfoMap=dataTable.asMap();
        openmrsmainPage.clickRegisterpatientButton();
        openmrsRegisterpage.sendName(patientInfoMap.get("GivenName"),patientInfoMap.get("FamilyName"));
        openmrsRegisterpage.SendGender(patientInfoMap.get("Gender"));
        openmrsRegisterpage.sendBirthday(patientInfoMap.get("Day"),patientInfoMap.get("Month"),patientInfoMap.get("Year"));
        openmrsRegisterpage.sendAddress(patientInfoMap.get("Address"));
        openmrsRegisterpage.sendphonenumber(patientInfoMap.get("PhoneNumber"));
        openmrsRegisterpage.sendRelativeInfo(patientInfoMap.get("RelationType"),patientInfoMap.get("RelativeName"));
        openmrsRegisterpage.clickConfirmButton();

    }
    @Then("the user validates the patient name and familyName")
    public void the_user_validates_the_patient_name_and_family_name(DataTable dataTable) {
        Map<String,String> validateNames=dataTable.asMap();
        Assert.assertEquals(validateNames.get("GivenName"),openmrsRegisterpage.getGivenName());
        Assert.assertEquals(validateNames.get("FamilyName"),openmrsRegisterpage.getFamilyName());
    }

}
