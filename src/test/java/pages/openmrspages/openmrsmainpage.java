package pages.openmrspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class openmrsmainpage {

    public openmrsmainpage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    WebElement registerPatientButton;

    public void clickRegisterpatientButton(){
        registerPatientButton.click();
    }






        }
