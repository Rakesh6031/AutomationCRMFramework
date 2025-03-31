package genericUtility;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author Rakesh
 * This class contains all the methods related to generate random number plus string and also to get system date and time
 */
public class JavaUtility {
	
	   
		
		public String randomeNumber()
		{
			String generatednumber=RandomStringUtils.randomNumeric(10);
			return generatednumber;
		}
		
		
		public int toGenerateRandomInt(int min, int max) {
	        if (min > max) {
	            throw new IllegalArgumentException("Min cannot be greater than Max");
	        }
	        return (int) (Math.random() * (max - min + 1)) + min;  // Generates a random integer between min and max
	    }
	    public String randomeString()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(5);
			return generatedstring;
		}
        public String randomeAlphaNumberic()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(3);
			String generatednumber=RandomStringUtils.randomNumeric(3);
			return (generatedstring+"@"+generatednumber);
		}
        /**
         * this method is used to generate random number
         * @return
         */
        public int toGetRandomnumber() {
        	Random r=new Random();
        	int value=r.nextInt();
        	return value;
        }
        /**
         * This method is used to get system date and time format
         * @return
         */
        public String toGetSystemDateAndTime(){
        	Date d=new Date();
    		System.out.println(d);
    		
    		String[] date=d.toString().split(" ");
        	String day=date[0];
    		String month=date[1];
    		String date1=date[2];
            String time=date[3].replace(":", "-");
            String year=date[5];
            
            String finalTime=day+" "+month+" "+date1+" "+time+" "+year;
            
            return finalTime;
        }
		

}
