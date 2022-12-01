package General;

import com.aventstack.extentreports.model.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static javax.xml.bind.JAXBIntrospector.getValue;

public class CapabilitiesGenerator {
    static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getCapabilities() {


        DesiredCapabilities caps = new DesiredCapabilities();
        try {

            caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus 3");
            caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "\\APK\\com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");
            //caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\VenD-Haris\\IdeaProjects\\AppiumFramework\\APK\\com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");
            //caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            caps.setCapability(MobileCapabilityType.NO_RESET, "true");
            //caps.setCapability(MobileCapabilityType.FULL_RESET, "false");
            // URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            //driver = new AndroidDriver<MobileElement>(url,caps);
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getValue("packageName"));
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getValue("activityName"));
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            caps.setCapability("unlockKey", "5421125");

        } catch (Exception exp) {
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("Message is: " + exp.getMessage());
            exp.printStackTrace();
        }
        return driver;
    }
}
