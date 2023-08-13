package Pages;

import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.driver.SHAFT;
public class GraphicsPage
{
    SHAFT.GUI.WebDriver driver;
    private static final By scaleToFit_Field =  AppiumBy.accessibilityId("ScaleToFit");
    private static final By vertices_Field =  AppiumBy.accessibilityId("Vertices");
    public GraphicsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public GraphicsPage scrollDownToScaleToFitField()
    {
        driver.element().scrollToElement(scaleToFit_Field);
        return this;
    }
    public GraphicsPage scrollDownToVerticesField()
    {
        driver.element().scrollToElement(vertices_Field);
        return this;
    }
    public GraphicsPage clickOnVerticesField()
    {
        driver.element().click(vertices_Field);
        return this;
    }
    public GraphicsPage clickOnScaleToFitField()
    {
        driver.element().click(scaleToFit_Field);
        return this;
    }
}
