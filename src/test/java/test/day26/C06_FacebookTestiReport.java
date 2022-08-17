package test.day26;



import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPages;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Locale;

public class C06_FacebookTestiReport extends TestBaseRapor {

    @Test
    public void facebookTest() {
        extentTest=extentReports.createTest("Facebook","Fake isimle girişin test edilmesi");
        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://facebook.com");
        extentTest.info("FaceBook sayfasına gidildi");
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker = new Faker();
        FaceBookPages facebookPage = new FaceBookPages();
        facebookPage.emailBox.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordBox.sendKeys(faker.internet().password());
        facebookPage.girisButton.click();
        extentTest.info("Facebook giriş bilgileri faker ile dolduruldu ve giriş butonuna tıklanıldı.");
        //4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.hataliGiris.isDisplayed());
        extentTest.pass("girilemediği test edildi");
        Driver.closeDriver();

    }

}
