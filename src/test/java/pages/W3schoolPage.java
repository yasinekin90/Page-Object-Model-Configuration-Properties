package pages;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class W3schoolPage {
    public W3schoolPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//h1)[1]")
    public WebElement htmlBasligi;

    @FindBy(xpath = "//a[text()=\"Next ❯\"]")
    public WebElement next;

    @FindBy(xpath = "(//h1)[1]")
    public WebElement htmlBorders;


}
