package Pages;

import com.shaft.driver.SHAFT;

import java.net.MalformedURLException;

public class Setup {
    SHAFT.GUI.WebDriver driver;

    public Setup(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public SHAFT.GUI.WebDriver setupDevice() throws MalformedURLException {
        SHAFT.Properties.platform.set().executionAddress("localhost:4723");
        SHAFT.Properties.platform.set().targetPlatform("Android");
        SHAFT.Properties.mobile.set().app(SHAFT.Properties.paths.testData()+"ApiDemos-debug.apk");
        SHAFT.Properties.mobile.set().deviceName("Demo");
        SHAFT.Properties.mobile.set().platformVersion("14.0");
        SHAFT.Properties.mobile.set().automationName("UiAutomator2");
        return driver;

    }
}
