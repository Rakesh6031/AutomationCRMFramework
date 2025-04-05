package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementations implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	/**
	 * Invoked before running all the test methods belonging to the classes inside
	 * the &lt;test&gt; tag and calling all their Configuration methods.
	 *
	 * @param context The test context
	 */
	public void onStart(ITestContext context) {
		System.out.println("---Suite Execution Started---");

		ExtentSparkReporter htmlReport = new ExtentSparkReporter(
				"./ExtentReports/Reports-" + new JavaUtility().toGetSystemDateAndTime() + ".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTIGER EXECUTION REPORT");

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("BaseUrl", "http://localhost:8888/");
		report.setSystemInfo("username", "admin");
		report.setSystemInfo("password", "password");
		report.setSystemInfo("Reporter Name", "lalu");
	}

	/**
	 * Invoked each time before a test will be invoked. The <code>ITestResult</code>
	 * is only partially filled with the references to class, method, start millis
	 * and status.
	 *
	 * @param result the partially filled <code>ITestResult</code>
	 * @see ITestResult#STARTED
	 */
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "---Started---");
		test = report.createTest(methodname);
	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS
	 */
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "---Passed---");
		test.log(Status.PASS, methodname + "----Passed");
	}

	/**
	 * Invoked each time a test is skipped.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SKIP
	 */
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "---Skipped---");
		test.log(Status.SKIP, methodname + "---Skipped");
		test.log(Status.INFO, result.getThrowable());
	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#FAILURE
	 */
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "---Failed---");
		test.log(Status.FAIL, methodname + "---Failed");
		//test.log(Status.FAIL, result.getThrowable());
		test.log(Status.INFO, result.getThrowable());

		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();

		String screenshotname = methodname + " " + jutil.toGetSystemDateAndTime();

		try {
			String path = wutil.toTakeSCreenshot(BaseClass.sdriver, screenshotname);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the
	 * &lt;test&gt; tag have run and all their Configuration methods have been
	 * called.
	 *
	 * @param context The test context
	 */
	public void onFinish(ITestContext context) {
		System.out.println("---Suite Execution Finished---");
		report.flush();
	}

}
