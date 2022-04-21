package pages.openmrspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class openMrsRegisterPage {

    public openMrsRegisterPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='givenName']")
    private WebElement GivenName;

    @FindBy(name = "familyName")
    private WebElement familyName;

    @FindBy(id = "next-button")
    private WebElement nextButton;

    @FindBy(id = "gender-field")//selectTag
    private WebElement selectGender;

    @FindBy(name = "birthdateDay")
    private WebElement birthDay;

    @FindBy(id = "birthdateMonth-field")
    private WebElement selectBirthMonth;
    @FindBy(xpath = "//input[@name='birthdateYear']")
    private WebElement birthYear;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address;

    @FindBy(name = "phoneNumber")
    WebElement phonenumber;

    @FindBy(id = "relationship_type")
    private WebElement relationType;

    @FindBy(xpath = "//input[@placeholder='Person Name']")
    private WebElement relativeName;

    @FindBy(id = "submit")
    private WebElement confirmButton;
    @FindBy(xpath = "//span[@class='PersonName-givenName']")
    private WebElement validateGivenName;
    @FindBy(xpath = "//span[@class='PersonName-familyName']")
    private WebElement validatefamilyName;

    public void sendName(String name,String familyName) throws InterruptedException {
        this.GivenName.sendKeys(name);
        this.familyName.sendKeys(familyName);
        Thread.sleep(3000);
        nextButton.click();
    }

    public void SendGender(String gender) throws InterruptedException {
        BrowserUtils.selectBy(selectGender,gender,"text");
        Thread.sleep(3000);
        nextButton.click();
    }

    public void sendBirthday(String day,String month,String year) throws InterruptedException {

        birthDay.clear();
        birthDay.sendKeys(day);
        BrowserUtils.selectBy(selectBirthMonth,month,"text");
        birthYear.clear();
        birthYear.sendKeys(year);
        Thread.sleep(3000);
        nextButton.click();
    }

    public void sendAddress(String address) throws InterruptedException {

        this.address.sendKeys(address);
        Thread.sleep(3000);
        nextButton.click();
    }

    public void sendphonenumber(String phoneNumber) throws InterruptedException {
        this.phonenumber.sendKeys(phoneNumber);
        Thread.sleep(3000);
        nextButton.click();
    }


    public void sendRelativeInfo(String relationType,String RelativeName) throws InterruptedException {
        BrowserUtils.selectBy(this.relationType,relationType,"text");
        this.relativeName.sendKeys(RelativeName);
        Thread.sleep(3000);
        nextButton.click();
    }

    public void clickConfirmButton(){
        confirmButton.click();
    }


    public String getGivenName(){
        return BrowserUtils.getText(validateGivenName);
    }
    public String getFamilyName(){
        return BrowserUtils.getText(validatefamilyName);
    }
}
