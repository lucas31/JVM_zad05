package shloogie;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThreadingTest {
    
	public static void main(String args[]) throws ParseException, InterruptedException {

		    DateFormat date = new SimpleDateFormat("YYYYMMdd");
			System.out.println("Correct date: " + date.parse("20170518") + "\n===================================");
		
			//not thread safe
			for (int i=0; i<50; i++) {
				ThreadRunner thread = new ThreadRunner(i);
				thread.start();
			}
			
			Thread.sleep(1000);
			
			//thread safe
			for (int i=0; i<50; i++) {
				SafeThreadRunner thread = new SafeThreadRunner(i);
				thread.start();
			}
	   }   
}
