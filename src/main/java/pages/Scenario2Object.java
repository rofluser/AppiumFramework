package pages;

import General.BaseClass;
import General.MainCall;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.*;

public class Scenario2Object extends BaseClass {
    public static By multiChoiceMode = By.xpath("//android.widget.TextView[@text='Multiple-choice mode']");
    public static By itemsSelect = By.xpath("//android.widget.CheckedTextView");
    public static By settingsLocator = By.xpath("//android.widget.TextView[@text='Network & internet']");
    //public static By deleteItems = By.xpath("//android.view.ViewGroup[4]/android.widget.LinearLayout/android.widget.ImageView[2]");

    public static AppiumDriver driver2;
    ArrayList<String> namesOfDeletedItems = new ArrayList<String>();
    ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
    int itemsToFind = 5;
    String expectedState = "NOT_RUNNING";

    public void navigateBack() {
        driver.navigate().back();
    }

    public void clickOnMultipleChoiceMode() {
        driver.findElement(multiChoiceMode).click();
    }

    public void selectRadioButtonRandomly() {
        //cannot be greater than names list in size
        List<WebElement> names = driver.findElements(itemsSelect);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int r = 1; r < names.size(); r++) {
            list.add(r);
        }
        Collections.shuffle(list);
        for (int p = 0; p < itemsToFind; p++) {
            randomNumbers.add(list.get(p));
        }
        System.out.println();
        System.out.println("Size of list is " + names.size());
        for (int i = 0; i < itemsToFind; i++) {
            System.out.println("Click on element at index " + randomNumbers.get(i));
            //System.out.println(names.get(randomNumbers.get(i)).getText());
            namesOfDeletedItems.add(names.get(randomNumbers.get(i)).getText());
            names.get(randomNumbers.get(i)).click();
        }
    }

    public void deleteSelectedButtons() {
        Collections.sort(randomNumbers);
        System.out.println("Sorted list is " + randomNumbers);
        int last = 0;
        int count = 1;
        for (int i = randomNumbers.size(); i > 0; i--) {
            last = randomNumbers.get(randomNumbers.size() - count); //getting last element of arraylist in incremental approach
            last++;
            By delete = By.xpath("//android.view.ViewGroup[" + last + "]/android.widget.LinearLayout/android.widget.ImageView[2]");
            WebElement deleteButton = driver.findElement(delete);
            deleteButton.click();
            count++;
        }
        System.out.println("Deleted Names are " + namesOfDeletedItems + " and size is " + namesOfDeletedItems.size());
    }

    public void checkDeletedItems() {
        List<WebElement> names = driver.findElements(itemsSelect);
        String deletedNames;
        for (int i = 0; i < namesOfDeletedItems.size(); i++) {
            deletedNames = names.get(i).getText();
            boolean b = namesOfDeletedItems.contains(deletedNames);
            if (b) {
                System.out.println("Deleted Value still exist case failed");
                Assert.assertFalse(b);
            }
        }
    }

    public void closeApp() {
        driver.terminateApp("com.mobeta.android.demodslv");
        ApplicationState state = driver.queryAppState("com.mobeta.android.demodslv");
        String stateValue = state.toString();
        System.out.println("State of the closed app is " + stateValue);
        Assert.assertEquals(expectedState, stateValue);
    }

    public void launchSecondApp() {
        // driver.installApp();
        driver.activateApp("com.android.settings");
    }

    public void waitForSettingsAppToOpen() {
        MainCall.genericFunctions.WaitForElement(settingsLocator);
    }

}
