package pages;

import General.BaseClass;
import General.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario3Object extends BaseClass {
    public static By demoAppLocator = By.xpath("//android.widget.TextView[@text='Basic usage playground']");

    public void launchTestApp() {
        driver.terminateApp("com.android.settings");
        driver.activateApp("com.mobeta.android.demodslv");
    }

    public void waitForDemoAppToLoad() {
        MainCall.genericFunctions.WaitForElement(demoAppLocator);
    }
}
