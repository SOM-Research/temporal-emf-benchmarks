package tll.time;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import tll.Component;

public class TimeDelay {
	
	public static void simulateProcessingTime(Component c) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, c.getUncertainty() + 1);
		int actualProcessingTime = (Math.random() <= 0.5) ? c.getProcessingTime() + randomNum : c.getProcessingTime() - randomNum; 
			
		try {
			TimeUnit.MILLISECONDS.sleep(actualProcessingTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		long start = System.nanoTime();
//		while(start + actualProcessingTime >= System.nanoTime());
	}
}
