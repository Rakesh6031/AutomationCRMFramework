package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementations implements ITestListener{
	
	/**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
	   * tag and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	  public void onStart(ITestContext context) {
	      System.out.println("---Suite Execution Started---");
	  }
	  
	  /**
	   * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	   * filled with the references to class, method, start millis and status.
	   *
	   * @param result the partially filled <code>ITestResult</code>
	   * @see ITestResult#STARTED
	   */
	  public void onTestStart(ITestResult result) {
	      String methodname=result.getMethod().getMethodName();
	      System.out.println(methodname+"---Started---");
	  }
	  
	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	  public void onTestSuccess(ITestResult result) {
		  String methodname=result.getMethod().getMethodName();
	      System.out.println(methodname+"---Passed---");
	  }
	  
	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  public void onTestSkipped(ITestResult result) {
		  String methodname=result.getMethod().getMethodName();
	      System.out.println(methodname+"---Skipped---");
	  }
	  
	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  public void onTestFailure(ITestResult result) {
		  String methodname=result.getMethod().getMethodName();
	      System.out.println(methodname+"---Failed---");
	      
	      WebDriverUtility wutil=new WebDriverUtility();
	      JavaUtility jutil=new JavaUtility();
	      
	      String screenshotname=methodname+" "+jutil.toGetSystemDateAndTime();
	      
	      try {
			wutil.toTakeSCreenshot(BaseClass.sdriver, screenshotname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	   * run and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public void onFinish(ITestContext context) {
	      System.out.println("---Suite Execution Finished---");
	  }

}
