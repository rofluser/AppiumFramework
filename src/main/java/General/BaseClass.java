package General;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
    public static AppiumDriver driver;
    public static CapabilitiesGenerator cap;

    @BeforeTest
    public void setUp() {
        driver = cap.getCapabilities();
    }

    @AfterTest
    public void tearDown() {

    }
}
