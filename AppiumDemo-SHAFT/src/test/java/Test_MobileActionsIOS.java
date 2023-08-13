import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Test_MobileActionsIOS {
    WebDriver driver;
    MobileActions MobileActions;

    @BeforeMethod
    public void setupDevice() throws MalformedURLException {
        String AppName = System.getProperty("user.dir") + "/src/test/resources/TestDataFiles/SauceLabs.app";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone 14 Pro Max");
        caps.setCapability("appium:app", AppName);
        caps.setCapability("appium:platformVersion", "16.4");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:udid", "FC1EAAB9-4080-4BCE-85F8-52E08002CF0E");
        caps.setCapability("wdaStartupRetries", "4");
        caps.setCapability("iosInstallPause","8000" );
        caps.setCapability("wdaStartupRetryInterval", "20000");
        driver = new AppiumDriver(new URL("http://localhost:4723/"), caps);
        MobileActions = new MobileActions(driver);
    }

    @Test
    public void testClickAction() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(AppiumBy.accessibilityId("test-Username")).clear();
        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated((AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"PRODUCTS\"`]"))));
        Assert.assertEquals(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"PRODUCTS\"`]")).getText(), "PRODUCTS");
    }
    @Test
    public void testAddToCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(AppiumBy.accessibilityId("test-Username")).clear();
        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"test-ADD TO CART\"])[1]")).click();
        driver.findElement(AppiumBy.accessibilityId("test-Cart")).click();
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("Sauce Labs Backpack")).getText(), "Sauce Labs Backpack");
    }
    
    

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}