package selenium.framework;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Demo extends BaseClass{

	@Test
	public void firstTest() throws Exception
	{	
		String xp="";
		driver.get("https://www.youtube.com/");
		test.log(Status.PASS, "Website opened");
		
		xp="//input[@id='Search']";
		SelFunctions.drSendKeys(xp, "selenium +java");
		
		xp="//button[@id='search-icon-legacy']/yt-icon";
		SelFunctions.drClick(xp, "search Button");
	}
	
	@Test
	public void SecondTest() throws Exception
	{	
		String xp="";
		driver.get("https://www.youtube.com/");
		test.log(Status.PASS, "Website opened");
		
		xp="//input[@id='search']";
		SelFunctions.drSendKeys(xp, "selenium +java");
		
		xp="//button[@id='search-icon-legacy']/yt-icon";
		SelFunctions.drClick(xp, "search Button");
	}
}
