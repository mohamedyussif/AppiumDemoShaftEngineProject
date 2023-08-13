package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class AccessbilityPage
{
    SHAFT.GUI.WebDriver driver;
    private By accessibilityNodeProvider_Field = AppiumBy.accessibilityId("Accessibility Node Provider");
    private By accessibilityNodeQuerying_Field = AppiumBy.accessibilityId("Accessibility Node Querying");
    public AccessbilityPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public AccessbilityPage clickOnaccessibilityNodeQueryingField()
    {
        driver.element().click(accessibilityNodeQuerying_Field);
        return this;
    }
    public AccessbilityPage assertOnAccessbilityNodeProviderFieldIsDisplayedWithExpectedText(String expectedTextValue)
    {
        driver.assertThat().element(accessibilityNodeProvider_Field).text().equals(expectedTextValue);
        return this;
    }
}