package tut1.api.threads.running;

import java.util.concurrent.TimeUnit;

public class FiftWay {

	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
		
		
	 Thread t=	new Thread(new Runnable(){

			@Override
			public void run() {
				
				for (int i=10; i>0; i--){
					
					System.out.println("TICK TICK " + i);
					
					try {
						TimeUnit.MILLISECONDS.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}});
	 
	   t.start();
		
		
		System.out.println("Main thread ends here...");


	}

}
