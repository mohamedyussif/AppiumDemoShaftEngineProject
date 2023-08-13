package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RadioGroupPage
{
    SHAFT.GUI.WebDriver driver;
    private static By radiboxThatUserChoosed(String enterlabelValue)
    {
        return AppiumBy.accessibilityId(enterlabelValue);

    }
    public RadioGroupPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public RadioGroupPage clickOnRadioboxThatUserChoosed(String labelValue)
    {
        driver.element().click(radiboxThatUserChoosed(labelValue));
        return this;
    }
    public RadioGroupPage assertThatRadioboxUserChoosedIsChecked(String labelValue)
    {
//        Assert.assertTrue(Boolean.parseBoolean(driver.findElement(radiboxThatUserChoosed(labelValue)).getAttribute("Checked")));
        driver.assertThat().element(radiboxThatUserChoosed(labelValue)).isSelected();
        return this;
    }
}
