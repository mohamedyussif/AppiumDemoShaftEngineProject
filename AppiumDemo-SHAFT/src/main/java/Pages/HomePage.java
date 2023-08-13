package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.stringtemplate.v4.ST;

public class HomePage {
    SHAFT.GUI.WebDriver driver ;
    SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("simpleJSON.json");;

    private By accessibility_button = AppiumBy.accessibilityId("Access'ibility");
    private  By app =  AppiumBy.accessibilityId("App");
    private By accessibilityNodeProvider_button=AppiumBy.accessibilityId("Accessibility Node Provider");
    private By app_button=AppiumBy.accessibilityId("App");
    private static final By graphics =  AppiumBy.accessibilityId("Graphics");
    private static final By views =  AppiumBy.accessibilityId("Views");



    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;

    }

    public HomePage clickOnAccessibility(){
        driver.element().click(accessibility_button);
        return this;
    }
    public String getAccessibilityNodeProviderText(){
        return driver.element().getText(accessibilityNodeProvider_button);
    }

    public HomePage clickOnApp(){
        driver.element().click(app_button);
        return this;
    }

    public HomePage validateAccessibilityNodeProviderText(){
//        driver.assertThat().element(accessibilityNodeProvider_button).text().equals("Accessibility Node Provider");
        SHAFT.Validations.assertThat().object(driver.element().getText(accessibilityNodeProvider_button)).equals(testData.getTestData("Accessibility"));
        return  this;
    }
    public HomePage clickOnGraphics()
    {
        driver.element().click(graphics);
        return this;
    }
    public HomePage clickOnView()
    {
        driver.element().click(views);
        return this;
    }

}
