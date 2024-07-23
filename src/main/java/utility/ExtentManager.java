
package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentSparkReporter sparkReporter;

	public static ExtentReports getInstance() {
		if (extent == null) {
			sparkReporter = new ExtentSparkReporter("ExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}
		return extent;
	}

	public static ExtentTest createTest(String testName) {
		return getInstance().createTest(testName);
	}
}
