package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    public static ExtentReports extent;

    private static String reportFileName = "AutomationReport" + ".html";
    private static String fileSeparator = System.getProperty("file.separator");
    private static String reportFilePath = System.getProperty("user.dir") + fileSeparator + "TestReport";
    private static String reportFileLocation = reportFilePath + fileSeparator + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null) createExtentReports();
        return extent;
    }

    public static ExtentReports createExtentReports() {
        String fileName = getReportPath(reportFilePath);
        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");
        spark.config().setEncoding("utf-8");
        spark.config().setReportName(reportFileName);
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("App under test is", "Demo App");
        return extent;
    }

    private static String getReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created");
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
        return reportFileLocation;
    }


}
