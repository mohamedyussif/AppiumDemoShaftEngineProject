package Pages;

import Actions.MobileActions;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerticesPage
{
    SHAFT.GUI.WebDriver driver;
    public VerticesPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private By photo_Field =  AppiumBy.className("android.view.View");
    public VerticesPage swipePhotoFieldToLeft()
    {
        driver.element().touch().swipeElementIntoView(photo_Field, TouchActions.SwipeDirection.LEFT);
        return this;
    }
    public VerticesPage swipePhotoFieldToRight()
    {
        driver.element().touch().swipeElementIntoView(photo_Field, TouchActions.SwipeDirection.LEFT);;
        return this;
    }
}
