package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AmazonAramaTest {
    AmazonPage amazonPage=new AmazonPage();

    @Test
    public void aramaTesti(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        amazonPage.aramakutusu.sendKeys("ipad", Keys.ENTER);

        for (WebElement titleAll:amazonPage.aramaText) {
            System.out.println("titleAll.getText() = " + titleAll.getText());
        }
        amazonPage.ilkUrun.click();

     String productTitle= amazonPage.elementTitle.getText();

        Assert.assertTrue(productTitle.contains("Apple"));

       // Driver.closeDriver();
    }
}
