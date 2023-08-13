package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
public class CustomTitlePage
{
    SHAFT.GUI.WebDriver driver;

    private By editText_Field =  AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Left is best\"]");
    private By changeLeft_Button =  AppiumBy.accessibilityId("Change Left");
    public CustomTitlePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public CustomTitlePage clickOnEditTextField()
    {
        driver.element().click(editText_Field);
        return this;
    }
    public CustomTitlePage clearEditTextField()
    {
        driver.element().clear(editText_Field);
        return this;
    }
    public CustomTitlePage sendKeysToEditTextField(String editTextField_EnteredWord)
    {
        driver.element().type(editText_Field, editTextField_EnteredWord);
        return this;
    }
    public CustomTitlePage clickOnChangeLeftButton()
    {
        driver.element().click(changeLeft_Button);
        return this;
    }
    public CustomTitlePage assertOnEnteredWordForEditTextField(String editTextField_ExpectedTextValue)
    {
        driver.assertThat().element(editText_Field).text().equals(editTextField_ExpectedTextValue);
        return this;
    }
}
