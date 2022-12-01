package test;

import General.BaseClass;
import General.MainCall;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.util.prefs.BackingStoreException;

public class Scenario2 extends BaseClass {
    @Test
    public static void scenario2() {
        //MainCall.scn2.navigateBack();
        MainCall.scn2.clickOnMultipleChoiceMode();
        MainCall.scn2.selectRadioButtonRandomly();
        MainCall.scn2.deleteSelectedButtons();
        MainCall.scn2.checkDeletedItems();
        MainCall.scn2.closeApp();
        MainCall.scn2.launchSecondApp();
        MainCall.scn2.waitForSettingsAppToOpen();
    }
}
