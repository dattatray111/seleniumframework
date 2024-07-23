package selenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;

public class SelFunctions extends BaseClass {

	public static void drClick(String xpath, String eleName) throws Exception {
		try {
			WebElement ele = driver.findElement(By.xpath(xpath));
			if (ele.isDisplayed()) {
				try {
					ele.click();
					extentLog(Status.PASS, true, "Clicked on webelement " + eleName);
				} catch (Exception e) {
					extentLog(Status.FAIL, true, "Unable to click on webelement " + eleName);

				}
			} else {
				extentLog(Status.FAIL, true, eleName + " Webelement is not displayed ");

			}
		} catch (Exception e) {
			extentLog(Status.FAIL, true, "Error while clciking on webelement " + eleName);
			throw new Exception(e.getMessage());
		}

	}

	public static void drSendKeys(String xpath, String textToEnter) throws Exception {

		try {
			WebElement ele = driver.findElement(By.xpath(xpath));

			if (ele.isDisplayed()) {
				try {
					ele.clear();
					ele.sendKeys(textToEnter);
					extentLog(Status.PASS, true, textToEnter + "  text is enetered");
				} catch (Exception e) {
					extentLog(Status.FAIL, true, "Not able to Enter text " + textToEnter);
				}
			} else {
				extentLog(Status.FAIL, true, " Webelement is not displayed ");
			}

		} catch (Exception e) {
			extentLog(Status.FAIL, true, "Error while Entering Text");
			throw new Exception(e.getMessage());
		}

	}
	
	public static void extentLog(Status status, boolean flag,  String msg) throws Exception
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
			test.addScreenCaptureFromPath(takeSnapShot(driver,new Exception().getStackTrace()[0].getMethodName()));
		}
		
	}
}
