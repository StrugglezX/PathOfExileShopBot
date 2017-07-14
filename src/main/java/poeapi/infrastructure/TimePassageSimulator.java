package poeapi.infrastructure;

import java.util.concurrent.TimeUnit;

public class TimePassageSimulator {

	public void simulateTimePassage(int msec){
		try {
			TimeUnit.MILLISECONDS.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
