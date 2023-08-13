package Pages;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.driver.SHAFT;

public class ActivityPage
{
    SHAFT.GUI.WebDriver driver;
    public ActivityPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private  By customTitle_Field =  AppiumBy.accessibilityId("Custom Title");
    public ActivityPage clickOnCustomTitleField()
    {
        driver.element().click(customTitle_Field);
        return this;
    }
}
