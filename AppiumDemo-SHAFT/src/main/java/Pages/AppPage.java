package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.driver.SHAFT;
public class AppPage
{
    SHAFT.GUI.WebDriver driver;
    public AppPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private By activity_Field =  AppiumBy.accessibilityId("Activity");
    public AppPage clickOnActivityField()
    {
        driver.element().click(activity_Field);
        return this;
    }
}