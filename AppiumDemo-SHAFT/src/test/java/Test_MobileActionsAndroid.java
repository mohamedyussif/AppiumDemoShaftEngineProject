import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Test_MobileActionsAndroid {
    By LeftTopTitle_text = By.id("io.appium.android.apis:id/left_text_edit");
    WebDriver driver;
    MobileActions MobileActions;

    @BeforeMethod
    public void setupDevice() throws MalformedURLException {
        String AppName = System.getProperty("user.dir") + "/src/test/resources/TestDataFiles/ApiDemos-debug.apk";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Demo");
        caps.setCapability("appium:app", AppName);
        caps.setCapability("appium:platformVersion", "13.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        MobileActions = new MobileActions(driver);
    }

    @Test
    public void testClickAction() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(AppiumBy.accessibilityId("Access'ibility")).click();
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("Accessibility Node Provider")).getText(), "Accessibility Node Provider");
    }

    @Test(dependsOnMethods = "testClickAction")
    public void testTyping() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Activity")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom Title")).click();
        driver.findElement(LeftTopTitle_text).clear();
        driver.findElement(LeftTopTitle_text).sendKeys("Appium");
        driver.findElement(AppiumBy.accessibilityId("Change Left")).click();
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Left is best\"]")).getText(), "Appium");
    }

    @Test(dependsOnMethods = "testTyping")
    public void testCheckBox() {
        driver.findElement(AppiumBy.accessibilityId("Access'ibility")).click();
        driver.findElement(AppiumBy.accessibilityId("Accessibility Node Querying")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Task Conquer World\"]//parent::android.widget.LinearLayout/android.widget.CheckBox")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Task Conquer World\"]//parent::android.widget.LinearLayout/android.widget.CheckBox")).getAttribute("checked"), "true", "CheckBox checked");
    }

    @Test(dependsOnMethods = "testCheckBox")
    public void testScrolling() {
        driver.findElement(AppiumBy.accessibilityId("Graphics")).click();
//        driver.findElement(AppiumBy.accessibilityId("ScaleToFit")).click();
        MobileActions.scrollDownToSpecificText("ScaleToFit");
        driver.findElement(AppiumBy.accessibilityId("ScaleToFit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Graphics/ScaleToFit')]")).getText(), "Graphics/ScaleToFit");
    }

    @Test(dependsOnMethods = "testScrolling")
    public void testSwiping() {
        driver.findElement(AppiumBy.accessibilityId("Graphics")).click();
        MobileActions.scrollDownToSpecificText("Vertices");
        driver.findElement(AppiumBy.accessibilityId("Vertices")).click();
        MobileActions.swipeRightOnElement(By.xpath("//android.view.View"), driver);
        MobileActions.swipeLeftOnElement(By.xpath("//android.view.View"));
    }

    @Test(dependsOnMethods = "testSwiping")
    public void testRadioButton() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        MobileActions.scrollDownToSpecificText("Radio Group");
        driver.findElement(AppiumBy.accessibilityId("Radio Group")).click();
        driver.findElement(By.id("io.appium.android.apis:id/breakfast")).click();
        Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/breakfast")).getAttribute("checked"), "true");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
