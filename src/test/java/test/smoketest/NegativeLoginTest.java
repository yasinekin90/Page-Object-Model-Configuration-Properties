package test.smoketest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTest {
    //todo
    //  //1) smokeTest  paketi altinda yeni bir Class olustur: NegativeTest
    //        //3 Farkli test Methodunda 3 senaryoyu test et
    //        //                - yanlisSifre
    //        //                - yanlisKulllanici
    //        //                - yanlisSifre ve Kullanici
    //        //test data yanlis username: manager1 , yanlis password : manager1
    //        //2) https://www.hotelmycamp.com/ adresine git

    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

    @Test
    public void yanlisSifre(){

        Driver.getDriver().get(ConfigurationReader.getProperty("HMCUrl"));
       hotelMyCampPage.logIn.click();
       hotelMyCampPage.userName.sendKeys(ConfigurationReader.getProperty("HMCValidUserName"));
       hotelMyCampPage.passWord.sendKeys(ConfigurationReader.getProperty("HMCWrongPassword"));
       hotelMyCampPage.loginButton.click();
        System.out.println("hotelMyCampPage.errorMsg.getText() = " + hotelMyCampPage.errorMsg.getText());
        Assert.assertTrue(hotelMyCampPage.errorMsg.getText().contains("Try again please"),"Yanlış şifre ile giriş yapıldı");

    }

    @Test
    public void yanlisKullanici(){
        Driver.getDriver().get(ConfigurationReader.getProperty("HMCUrl"));
        hotelMyCampPage.logIn.click();
        hotelMyCampPage.userName.sendKeys(ConfigurationReader.getProperty("HMCWrongUserName"));
        hotelMyCampPage.passWord.sendKeys(ConfigurationReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.loginButton.click();
        //verilen senaryolarla ilgili giriş yapılamadıgının test kontrolu
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(hotelMyCampPage.errorMsg.isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void yanlisSifreVeKullanici(){
        Driver.getDriver().get(ConfigurationReader.getProperty("HMCUrl"));
        hotelMyCampPage.logIn.click();
        hotelMyCampPage.userName.sendKeys(ConfigurationReader.getProperty("HMCWrongUserName"));
        hotelMyCampPage.passWord.sendKeys(ConfigurationReader.getProperty("HMCWrongPassword"));
        hotelMyCampPage.loginButton.click();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(hotelMyCampPage.errorMsg.isDisplayed());
        softAssert.assertAll();
    }
}
