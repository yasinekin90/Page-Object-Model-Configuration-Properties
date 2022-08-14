package test.smoketest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class PositiveLoginTest {
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

    @Test
    public void positiveLoginTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("HMCUrl"));
        hotelMyCampPage.logIn.click();
        hotelMyCampPage.userName.sendKeys(ConfigurationReader.getProperty("HMCValidUserName"));
        hotelMyCampPage.passWord.sendKeys(ConfigurationReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.loginButton.click();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(hotelMyCampPage.listOfUser.isDisplayed());
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
