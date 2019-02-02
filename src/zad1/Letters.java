package zad1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class Letters {
	
	HashMap<Thread, String> myMap = new LinkedHashMap<>();
	
	public Letters(String text) {
		
			 for(int i=0; i<text.length(); i++) {
				 Thread thread = new Thread( 
						() -> {
						while(!Thread.interrupted()) {
						try { Thread.sleep(1000); }
						catch (InterruptedException e) { break; }
						System.out.print(myMap.get(Thread.currentThread()));
						}
				 });				 
				thread.setName("Thread " + text.charAt(i));
				myMap.put(thread, Character.toString(text.charAt(i)));
			 }			 	  
	}
	
	public Set<Thread> getThreads() { return myMap.keySet(); }

}

