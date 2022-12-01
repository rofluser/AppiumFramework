package test;

import General.BaseClass;
import General.MainCall;
import org.testng.annotations.Test;

public class Scenario3 extends BaseClass {
    @Test
    public void scenario3() {
        MainCall.scn3.launchTestApp();
        MainCall.scn3.waitForDemoAppToLoad();
    }

}
