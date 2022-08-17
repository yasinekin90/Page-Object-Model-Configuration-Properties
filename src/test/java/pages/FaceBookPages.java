package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FaceBookPages {
    public FaceBookPages(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(linkText = "Yeni Hesap Oluştur")
    public WebElement createAccount;
    @FindBy(xpath = "//input[@placeholder=\"Adın\"]")
    public WebElement nameHolder;

    @FindBy(xpath = "//select[@title=\"Gün\"]")
    public WebElement day;

    @FindBy(xpath = "//select[@title=\"Ay\"]")
    public WebElement month;

    @FindBy(xpath = "//select[@title=\"Yıl\"]")
    public WebElement year;
            @FindBy(xpath = "//label[text()=\"Kadın\"]")
    public WebElement female;
            @FindBy(xpath = "//button[text()=\"Kaydol\"]")
    public WebElement kaydol;

    @FindBy(xpath = "//input[@class='inputtext _55r1 _6luy']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@class='inputtext _55r1 _6luy _9npi']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")
    public WebElement girisButton;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement hataliGiris;

}
