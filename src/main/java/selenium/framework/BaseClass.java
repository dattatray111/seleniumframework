package selenium.framework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.ExtentManager;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentManager extentManager;

	public static String takeSnapShot(WebDriver webdriver) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir") + "/failedTestCaseSC/"  + dateName + ".png";
		File destFile = new File(Destination);
		FileUtils.copyFile(SrcFile, destFile);
		return Destination;
	}
	
	public static TakesScreenshot takeSnapShot1(WebDriver webdriver) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir") + "/failedTestCaseSC/"  + dateName + ".png";
		File destFile = new File(Destination);
		FileUtils.copyFile(SrcFile, destFile);
		return scrShot;
	}
	
	
	public static void initReport(String reportName) {
		if (extent == null) {
			sparkReporter = new ExtentSparkReporter("ExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}
		
    }

	public static ExtentTest createTest(String testName) {
        return test = extent.createTest(testName);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
        	 driver = new ChromeDriver();
        	 driver.navigate().to("https://www.google.com/");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
	


}
