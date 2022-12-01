package pages;


import General.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class Scenario1Object extends BaseClass {
    public static By warp = By.xpath("//android.widget.TextView[@text='Warp']");
    public static By afg = By.xpath("//android.widget.TextView[@text='Afghanistan']");
    public static By countryID = By.className("android.widget.TextView");
    public static By countryList = By.xpath("//android.widget.FrameLayout/android.widget.ListView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView");
    int indexOfCountry = 0;

    public void clickWrap() throws MalformedURLException {
        driver.findElement(warp).click();
    }

    public void scrollToNigeria() {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Nigeria\"))"));
    }

    public void dragNigeriaToTop() {
        List<WebElement> countries = driver.findElements(countryID);
        for (int j = 0; j < countries.size(); j++) {
            if (countries.get(j).getText().equals("Nigeria")) {
                indexOfCountry = j;
                //System.out.println("Index no is " + indexOfCountry);
                By countryDragHandle = By.xpath("(//*[@resource-id= 'com.mobeta.android.demodslv:id/drag_handle'])[" + indexOfCountry + "]");
                MobileElement requiredCountry = (MobileElement) driver.findElement(countryDragHandle);
                TouchAction action = new TouchAction(driver);
                MobileElement toTarget = (MobileElement) driver.findElement(warp);
                action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(requiredCountry))).moveTo((ElementOption.element(toTarget))).release().perform();
                break;
            }
        }

    }

    public void scrollToAndRemoveAfghanistan() {
        boolean elementVisible = true;
        boolean textVisible = true;
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Afghanistan\"))"));
        List<WebElement> countries = driver.findElements(countryID);
        for (int j = 0; j < countries.size(); j++) {
            if (countries.get(j).getText().equals("Afghanistan")) {
                indexOfCountry = j;
                By countryDragHandle = By.xpath("(//*[@resource-id= 'com.mobeta.android.demodslv:id/drag_handle'])[" + indexOfCountry + "]");
                WebElement requiredCountry = driver.findElement(countryDragHandle);
                TouchAction action = new TouchAction(driver);
                action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(requiredCountry))).perform().moveTo(PointOption.point(-15, 540)).perform();
                //action.press(ElementOption.element(requiredCountry)).moveTo(PointOption.point(0, 609)).release().perform();
                List<WebElement> coun = driver.findElements(countryID);
                String firstCountry = String.valueOf(coun.get(1).getText());
                if (!firstCountry.equals("Nigeria")) {
                    textVisible = false;
                }
                for (WebElement web : coun) {
                    System.out.println("Country name is " + web.getText());
                    String s = web.getText();
                    if (s.equals("Afghanistan")) {
                        elementVisible = false;
                        break;
                    }
                }
                Assert.assertTrue(elementVisible);
                Assert.assertTrue(textVisible);
                break;

            }
        }
    }
}
