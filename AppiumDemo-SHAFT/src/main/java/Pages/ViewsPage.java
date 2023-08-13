package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ViewsPage
{
    SHAFT.GUI.WebDriver driver;
    private By radioGroup_Field = AppiumBy.accessibilityId("Radio Group");
    public ViewsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public ViewsPage swipeDownToRadioGroupAndClickOnIt()
    {
        driver.element().touch().swipeElementIntoView("Radio Group").tap(radioGroup_Field);
        return this;
    }

}
