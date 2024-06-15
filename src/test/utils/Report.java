package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Report {
    private WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    public void createReport() {
        extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("report.html");
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setDocumentTitle("Selenium Practice App Altan");
        reporter.config().setReportName("Selenium Practice App Altan");
        extentReports.attachReporter(reporter);
    }

    public void closeReport() {
        extentReports.flush();
    }

    public ExtentTest createTestReport(WebDriver driver, Method method) {
        this.driver = driver;
        extentTest = extentReports.createTest(getTestNameAndDescription(method));
        return extentTest;
    }

    public void logInfo(Object object){
        extentTest.info(MarkupHelper.createJsonCodeBlock(object));
    }

    public void logScreenshot(String title) {
        extentTest.pass(title, MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot.takeScreenshot(driver)).build());

    }
    public void logTestResult(ITestResult result){
        if (result.getStatus() == ITestResult.SUCCESS){
            extentTest.pass("TEST PASSED");
        }else if (result.getStatus() == ITestResult.FAILURE){
            extentTest.fail("TEST FAILED");
            logScreenshot("Screenshot");
            extentTest.fail(result.getThrowable());
        }
    }
    public String getTestNameAndDescription(Method method){
        Test testDetails = method.getAnnotation(Test.class);
        Test testDescription = method.getAnnotation(Test.class);
        if (!testDetails.testName().isEmpty() && !testDescription.description().isEmpty()){
            return testDetails.testName() + testDescription.description();
        }else {
            return method.getName();
        }
    }

    public void setAuthor(String author) {
        extentTest.assignAuthor(author);
    }
}
