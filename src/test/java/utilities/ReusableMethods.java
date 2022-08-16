package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReusableMethods {


    public static String getScreenShot(String name) throws IOException {
        String date=new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        TakesScreenshot ts= (TakesScreenshot) Driver.getDriver();
        File source=ts.getScreenshotAs(OutputType.FILE);
        String target= System.getProperty("user.dir")+"target/test-output/Screenshots"+name+date+".png";
        File file=new File(target);
        FileUtils.copyFile(source,file);

        return target;
    }

    public static void hover(WebElement element){
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();

    }

    public static List<String>getElementsText(By locator){
        List<WebElement> elements=Driver.getDriver().findElements(locator);
        List<String> elementText=new ArrayList<>();
        for (WebElement elt:elements) {
            if(!elt.getText().isEmpty()){
               elementText.add(elt.getText());
            }
        }
        return elementText;
    }

    //***************Explicitly wait*************************

    public static WebElement waitForVisibility(WebElement element,int time){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator,int time){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
