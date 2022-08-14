package test;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.W3schoolPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Locale;

public class W3schools {
W3schoolPage w3schoolPage=new W3schoolPage();


    @Test
    public void test01(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url1"));
        String title=w3schoolPage.htmlBasligi.getText();
        Assert.assertTrue(title.equals("HTML Tables"));
        System.out.println("title = " + title);

        w3schoolPage.next.click();

        String htmlBorders=w3schoolPage.htmlBorders.getText();
        Assert.assertTrue(htmlBorders.equals("HTML Table Borders"));
        System.out.println("htmlBorders = " + htmlBorders);
    }
}
