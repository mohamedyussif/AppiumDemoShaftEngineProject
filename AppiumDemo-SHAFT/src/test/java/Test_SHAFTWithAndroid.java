import Pages.*;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class Test_SHAFTWithAndroid {
    JSONFileManager jsonFileManager = new JSONFileManager("simpleJSON.json");

    SHAFT.GUI.WebDriver driver;
    @BeforeClass
    public void classSetup()
    {
        SHAFT.Properties.reporting.set().openAllureReportAfterExecution(true);
    }

    @Test
    public void testClickAction() {
        // Method 1 -->
         new HomePage(driver).clickOnAccessibility().validateAccessibilityNodeProviderText();
        // Method 2 (Native testng) --> Assert.assertEquals(new HomePage(driver).clickOnAccessibility().getAccessibilityNodeProviderText(),"Accessibility Node Provider");
        // Method 3 (SHAFT Validation) -->  SHAFT.Validations.assertThat().object(new HomePage(driver).clickOnAccessibility().getAccessibilityNodeProviderText()).equals("Accessibility Node Provider");
        // In case Assertion on the pages Method#1 --> driver.assertThat().element(accessibilityNodeProvider_button).text().equals("Accessibility Node Provider");
        // In case Assertion on the pages Method#2 -->  SHAFT.Validations.assertThat().object(driver.element().getText(accessibilityNodeProvider_button)).equals("Accessibility Node Provider");
    }
    @Test
    public void testTyping()
    {
        new HomePage(driver)
                .clickOnApp();
        new AppPage(driver)
                .clickOnActivityField();
        new ActivityPage(driver)
                .clickOnCustomTitleField();
        new CustomTitlePage(driver).
                clickOnEditTextField()
                .clearEditTextField()
                .sendKeysToEditTextField(jsonFileManager.getTestData("EnteredWord"))
                .clickOnChangeLeftButton()
                .assertOnEnteredWordForEditTextField(jsonFileManager.getTestData("ExpectedWord"));
    }
    @Test
    public void testCheckBox() {
        // Navigate to Access'ibility , Accessibility Node Querying , click on any checkbox and validate that the checkbox is checked
//        new HomePage(driver)
//                .clickOnAccessbility();
//        new AccessbilityPage(driver)
//                .clickOnaccessibilityNodeQueryingField();
//        new AccessbilityNodeQueryingPage(driver)
//                .clickOnCheckoboxThatUserChoosed(getValue("Chosen Checkbox"))
//                .assertthatChecboxThatUserChoosedIsChecked(getValue("Chosen Checkbox Assertion"));
        new HomePage(driver).clickOnAccessibility();
        new AccessbilityPage(driver)
                .clickOnaccessibilityNodeQueryingField();
        new AccessbilityNodeQueryingPage(driver)
                .clickOnCheckoboxThatUserChoosed(jsonFileManager.getTestData("ChosenCheckbox"))
                .assertthatChecboxThatUserChoosedIsChecked(jsonFileManager.getTestData("ChosenCheckboxAssertion"));

    }
    @Test
    public void testScrolling() {
        // Navigate to Graphics , scaleToFit and click on it and check If it's scrolled and clicked or not
//        new HomePage(driver)
//                .clickOnGraphics();
//        new GraphicsPage(driver)
//                .scrollDownToSpecificText(getValue("Graphics Scaletofit Tap"))
//                .clickOnScaleToFitField();
//        new ScaleToFitPage(driver)
//                .assertThatGraphicsScaleToFitIsDisplayed();
        new HomePage(driver)
                .clickOnGraphics();
        new GraphicsPage(driver)
                .scrollDownToScaleToFitField()
                .clickOnScaleToFitField();
        new ScaleToFitPage(driver)
                .assertThatGraphicsScaleToFitIsDisplayed(jsonFileManager.getTestData("GraphicsScaleToFitAssert"));

    }
    @Test
    public void testSwiping() {
        // Navigate to Graphics , Vertices , Swipe right on the photo and then swipe left
//        new HomePage(driver)
//                .clickOnGraphics();
//        new GraphicsPage(driver)
//                .scrollDownToSpecificText(getValue("Graphics vertices Tap"))
//                .clickOnVerticesField();
//        new VerticesPage(driver)
//                .swipePhotoFieldToLeft()
//                .swipePhotoFieldToRight(driver);
        new HomePage(driver)
                .clickOnGraphics();
        new GraphicsPage(driver)
                .scrollDownToVerticesField()
                .clickOnVerticesField();
        new VerticesPage(driver)
                .swipePhotoFieldToLeft()
                .swipePhotoFieldToRight();

    }
    @Test
    public void testRadioButton()
    {
        // Navigate to Views , Radio Group , click on any radio button and check If it's selected or not
//        new HomePage(driver)
//                .clickOnView();
//        new ViewsPage(driver)
//                .scrollDownToSpecificText(getValue("Views Radiobox Tap"));
//        new ViewsPage(driver)
//                .clickOnRadioGroupField();
//        new RadioGroupPage(driver)
//                .clickOnRadioboxThatUserChoosed(getValue("Chosen Radiobox"));
//        new RadioGroupPage(driver)
//                .assertThatRadioboxUserChoosedIsChecked(getValue("Chosen Radiobox Assertion"));
        new HomePage(driver)
                .clickOnView();
        new ViewsPage(driver)
                .swipeDownToRadioGroupAndClickOnIt();
        new RadioGroupPage(driver)
                .clickOnRadioboxThatUserChoosed(jsonFileManager.getTestData("ChosenRadiobox"))
                .assertThatRadioboxUserChoosedIsChecked(jsonFileManager.getTestData("ChosenRadioboxAssertion"));


    }

    @BeforeMethod
    public void beforeClass() throws MalformedURLException {
        new Setup(driver).setupDevice();
        driver = new SHAFT.GUI.WebDriver();

    }

    @AfterMethod(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }


}
