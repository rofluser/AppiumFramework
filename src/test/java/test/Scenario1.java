package test;

import General.BaseClass;
import General.MainCall;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Scenario1 extends BaseClass {
    @Test
    public static void scenario1() throws MalformedURLException {
        MainCall.scn1.clickWrap();
        MainCall.scn1.scrollToNigeria();
        MainCall.scn1.dragNigeriaToTop();
        MainCall.scn1.scrollToAndRemoveAfghanistan();
    }
}
