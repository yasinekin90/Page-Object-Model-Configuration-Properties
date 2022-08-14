package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class HotelMyCampPage {
    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement logIn;

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement passWord;

    @FindBy(id = "btnSubmit")
    public WebElement loginButton;

    @FindBy(id = "divMessageResult")
    public WebElement errorMsg;

    @FindBy(xpath = "//span[text()=\"ListOfUsers\"]")
    public WebElement listOfUser;

    @FindBy(xpath = "//span[text()=\"Hotel Management\"]")
    public WebElement hotelManagement;

    @FindBy(xpath = "(//i[@class=\"icon-calendar\"])[2]")
    public WebElement hotelList;

    @FindBy(xpath = "//span[text()=\"Add Hotel \"]")
    public WebElement addHotel;

    @FindBy(xpath = "//input[@placeholder=\"Code\"]")
    public WebElement code;

    @FindBy(id = "IDGroup")
    public WebElement idGroup;

    @FindBy(id = "btnSubmit")
    public WebElement save;

    @FindBy(className = "bootbox-body")
    public WebElement hotelWas;

    @FindBy(xpath = "//button[text()=\"OK\"]")
    public WebElement okButton;

    public void wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("HMCUrl"));

        logIn.click();
        userName.sendKeys(ConfigurationReader.getProperty("HMCValidUserName"));
        passWord.sendKeys(ConfigurationReader.getProperty("HMCValidPassword"));
        loginButton.click();
    }
}
