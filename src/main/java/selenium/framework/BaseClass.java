package selenium.framework;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utility.ExtentManager;


public class BaseClass {
	
	static WebDriver driver;
	static ExtentTest test;
	ExtentReports extent;
	
	
	public static String takeSnapShot(WebDriver webdriver,String scName) throws Exception{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String Destination= System.getProperty("user.dir")+"/failedTestCaseSC/"+scName+dateName+".png";
        File destFile = new File(Destination);
        FileUtils.copyFile(SrcFile, destFile);
        return Destination;
    }
	
	@BeforeMethod
	public void setUp(Method method)
	{
		driver = new ChromeDriver();
		extent = ExtentManager.getInstance();
		String testName = method.getName();
		test = ExtentManager.createTest(testName);
	}
	
	@AfterMethod
	public void cleanUp(Method method) throws Exception
	{
		extent.flush();
		driver.quit();
	}
	

}
