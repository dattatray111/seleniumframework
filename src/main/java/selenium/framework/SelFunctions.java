package selenium.framework;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v126.page.model.Screenshot;

import selenium.framework.*;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;

import io.cucumber.java.Scenario;

public class SelFunctions extends BaseClass
{	
	    WebDriver driver;
	    Scenario scenario;
	
	public SelFunctions(WebDriver driver) {
		this.driver =  BaseClass.driver;
	}
	
	public  void openUrl(String url)
	{
		driver.navigate().to(url);
	}

	public  void drClick(WebElement ele, String eleName) throws Exception {
		try {
			
			if (ele.isDisplayed()) {
				try {
					ele.click();
					extentLog(Status.PASS, true, "Clicked on webelement " + eleName);
				} catch (Exception e) {
					extentLog(Status.FAIL, false, "Unable to click on webelement " + eleName);

				}
			} else {
				extentLog(Status.FAIL, false, eleName + " Webelement is not displayed ");

			}
		} catch (Exception e) {
			extentLog(Status.FAIL, true, "Error while clciking on webelement " + eleName);
			throw new Exception(e.getMessage());
		}

	}

	public  void drSendKeys(WebElement ele, String textToEnter) throws Exception {

		try {

			if (ele.isDisplayed()) {
				try {
					ele.clear();
					ele.sendKeys(textToEnter);
					extentLog(Status.PASS, true, textToEnter + "  text is enetered");
				} catch (Exception e) {
					extentLog(Status.FAIL, true, "Not able to Enter text " + textToEnter);
				}
			} else {
				extentLog(Status.FAIL, false, " Webelement is not displayed ");
			}

		} catch (Exception e) {
			extentLog(Status.FAIL, false, "Error while Entering Text");
			throw new Exception(e.getMessage());
		}

	}
	
	public  void extentLog(Status status, boolean flag,  String msg) throws Exception
	{
		if(status.equals(status.FAIL))
		{
			test.log(Status.FAIL, msg);
		}
		if(status.equals(status.PASS))
		{
			test.log(Status.PASS, msg);
		}
		if(flag)
		{
			test.addScreenCaptureFromPath(BaseClass.takeSnapShot(driver));
		}
		
	}
}
