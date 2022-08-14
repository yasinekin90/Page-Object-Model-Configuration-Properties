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

}
