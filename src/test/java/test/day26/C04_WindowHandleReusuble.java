package test.day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.Set;

public class C04_WindowHandleReusuble {
    //todo
    // https://the-internet.herokuapp.com/windows sitesine gideli
    // new tab butonuna tıklayalım
    // new taba geçip titlen "New Window" olduğunu test edelim

    @Test
    public void test01(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String handle1=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.xpath("//a[@target=\"_blank\"]")).click();
        Set<String>handles=Driver.getDriver().getWindowHandles();

        String handle2="";

        for (String str:handles) {
            if(!str.equals(handle1)){
                handle2=str;
            }
        }
        WebDriver window = Driver.getDriver().switchTo().window(handle2);
        // new taba geçip titlen "New Window" olduğunu test edelim
        String expectedTitle="New Window";
        String actualTitle= window.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void windowHandleReusable() throws IOException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        Driver.getDriver().findElement(By.xpath("//a[@target=\"_blank\"]")).click();

        String expected="The Internet";
        ReusableMethods.switchToWindow("New Window");
       Assert.assertEquals(Driver.getDriver().getTitle(),expected);//hata verir çünkü yeni penceree gecis oldu
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
        ReusableMethods.getScreenshot("WindowHandle");
        Driver.closeDriver();
    }

    @Test
    public void demoqa() throws IOException {
        Driver.getDriver().get("https://demoqa.com/browser-windows");


        Driver.getDriver().findElement(By.id("tabButton")).click();


        String expected="ToolsQA";
        ReusableMethods.switchToWindow("");//yeni tabın baslıgı yok
        Assert.assertNotEquals(Driver.getDriver().getTitle(),expected);//eşit olmaması yeni taba geçildigi anlamnına gelir

        ReusableMethods.getScreenshot("demoqa");
        Driver.closeDriver();

    }
}
