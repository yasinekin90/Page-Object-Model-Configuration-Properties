package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {


    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id= "twotabsearchtextbox")
    public WebElement aramakutusu;

    @FindBy(xpath = "(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")
   public WebElement ilkUrun;
//
   @FindBy(id = "title")
   public WebElement elementTitle;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucText;

    @FindBy(xpath = "//span[@class=\"a-size-medium a-color-base a-text-normal\"]")
    public List<WebElement>  aramaText;

    @FindBy(className = "imgTagWrapper")
    public WebElement image;

}
