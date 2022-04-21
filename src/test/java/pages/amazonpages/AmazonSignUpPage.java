package pages.amazonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AmazonSignUpPage {

    public AmazonSignUpPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "nav-link-accountList-nav-line-1")
    WebElement helloButton;

    @FindBy(id = "createAccountSubmit")
    WebElement createamazonaccountbutton;

    @FindBy(id = "ap_customer_name")
    WebElement name;

    @FindBy(id = "ap_email")
    WebElement email;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(id = "ap_password_check")
    WebElement passwordCheck;
    @FindBy(tagName = "h1")
    WebElement headertext;

    public void setCreateAccount(){
        helloButton.click();
        createamazonaccountbutton.click();
    }

    public String getHeaderText(){
        return BrowserUtils.getText(headertext);
    }

    public void allInformation(String username,String email,String password,String passwordcheck){
        name.sendKeys(username);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.passwordCheck.sendKeys(passwordcheck);

    }


}
