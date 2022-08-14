package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.FaceBookPages;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Locale;

public class FaceBookTest {
FaceBookPages faceBookPages=new FaceBookPages();

    @Test

    public void test01(){
        Faker faker=new Faker(new Locale("tr","TR"));
        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigurationReader.getProperty("url3"));
        faceBookPages.createAccount.click();
        faceBookPages.nameHolder.sendKeys(faker.name().firstName());

        actions.keyDown(Keys.TAB).sendKeys(faker.name().lastName())
                .keyDown(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
                .keyDown(Keys.TAB).sendKeys("123456789").perform();
        Select select=new Select(faceBookPages.day);
        Select select1=new Select(faceBookPages.month);
        Select select2=new Select(faceBookPages.year);
        select.selectByValue("21");
        select1.selectByValue("10");
        select2.selectByValue("1983");
        faceBookPages.female.click();
        faceBookPages.kaydol.click();






    }
}
