package shloogie;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThreadRunner implements Runnable {
	   private Thread thread;
	   private int id;
	   private static final DateFormat date = new SimpleDateFormat("YYYYMMdd");
	    
	   public ThreadRunner(int id) { this.id = id; }	    
	   
	   public void run() {	      	      
	      try {
			System.out.println(id + " | " + date.parse("20170518"));
		} catch (ParseException e) {
			System.out.println(id + " threw exception");
		}      
	   }
	   
	   public void start () {
	      if (thread == null) {
	    	 thread = new Thread(this, id + "");
	    	 thread.start ();
	      }
	   }
	}