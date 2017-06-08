package shloogie;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SafeThreadRunner implements Runnable {
	private Thread thread;
	   private int id;
	   private static final ThreadLocal<SimpleDateFormat> date = new ThreadLocal<SimpleDateFormat>(){
		    @Override
		    protected SimpleDateFormat initialValue() {
		        return new SimpleDateFormat("YYYYMMdd");
		    }
		  };
		  
	   public SafeThreadRunner(int id) { this.id = id; }	    
	   
	   public void run() {	      	      
	      try {
			System.out.println("Safe " + id + " | " + date.get().parse("20170518"));
			Thread.sleep(1000);
		} catch (ParseException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
	   }
	   
	   public void start () {
	      if (thread == null) {
	    	 thread = new Thread(this, id + "");
	    	 thread.start ();
	      }
	   }
	}