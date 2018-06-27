package extent;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Utility {

	public static ExtentReports extent;
	public static ExtentTest logger;

	public static ExtentReports getInstanceExport() {
		if (extent == null) {
			extent = new ExtentReports(new File("D:\\lib") + "\\test-output\\STMExtentReport.html", true);
			 extent.loadConfig(new File("D:\\lib\\extent-config.xml"));
			
		}
		return extent;
	}

	public static ExtentTest getInstanceExtentTest() {
		if (logger == null) {
			logger = extent.startTest("passTest");
		}
		return logger;
	}

}
