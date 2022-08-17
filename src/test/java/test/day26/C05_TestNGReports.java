package test.day26;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class C05_TestNGReports extends TestBaseRapor {
    @Test
    public void windowHandleReusable() throws IOException {
        extentTest=extentReports.createTest("window Handle","title ile 2. sayfaya geçiş");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("harokuapp sayfasına gidildi");
        Driver.getDriver().findElement(By.xpath("//a[@target=\"_blank\"]")).click();
        extentTest.info("Click here butonuna tıklandı");
        String expected="New Window";
        ReusableMethods.switchToWindow("New Window");
        extentTest.info("Reusable Methot kullanılarak ikinci sayfaya geçildi");
        Assert.assertEquals(Driver.getDriver().getTitle(),expected);
        extentTest.pass("Title ın beklenen değer ile aynı olduğu test edildi");
        ReusableMethods.getScreenshot("WindowHandle1");

    }
}
