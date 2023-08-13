package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ScaleToFitPage
{
    SHAFT.GUI.WebDriver driver;
    private By textView = AppiumBy.xpath("//android.widget.TextView[@text='Graphics/ScaleToFit']");
    public ScaleToFitPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public ScaleToFitPage assertThatGraphicsScaleToFitIsDisplayed(String textview)
    {
//        Assert.assertTrue(driver.findElement(AppiumBy.className("android.widget.TextView")).isDisplayed());
        driver.assertThat().element(textView).text().equals(textview);
        return this;
    }
}
