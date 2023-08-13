package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.shaft.driver.SHAFT;

public class AccessbilityNodeQueryingPage
{
    SHAFT.GUI.WebDriver driver;
    private static By checkBox_FieldThatUserChoosed(String enterLabelValue)
    {
        return AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"Task "+enterLabelValue+"\"])/parent::android.widget.LinearLayout/android.widget.CheckBox");

    }
    public AccessbilityNodeQueryingPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public AccessbilityNodeQueryingPage clickOnCheckoboxThatUserChoosed(String labelValue)
    {
        driver.element().click(checkBox_FieldThatUserChoosed(labelValue));
        return this;
    }
    public AccessbilityNodeQueryingPage assertthatChecboxThatUserChoosedIsChecked(String labelValue)
    {
        //Assert.assertTrue(Boolean.parseBoolean(driver.findElement(checkBox_FieldThatUserChoosed(labelValue)).getAttribute("Checked")));
        driver.assertThat().element(checkBox_FieldThatUserChoosed(labelValue)).isChecked();
        return this;
    }
}

