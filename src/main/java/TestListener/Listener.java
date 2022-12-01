package TestListener;

import ExtentReport.ExtentManager;
import ExtentReport.ExtentTestManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("--Running Test Method " + iTestResult.getMethod().getMethodName());
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Case " + iTestResult.getMethod().getMethodName() + " is passed ");
        ExtentTestManager.getTest().log(Status.PASS, "Test is passed");
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Case " + iTestResult.getMethod().getMethodName() + " is failed ");
        ExtentTestManager.getTest().log(Status.FAIL, "Test is failed");
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
