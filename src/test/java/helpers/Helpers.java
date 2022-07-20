package helpers;

public class Helpers {
	
	public void sleepSeconds(int seconds) {
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
