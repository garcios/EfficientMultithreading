package tuts.common;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LoopTaskI implements Runnable{

	private static int count=0;
	private int instanceNumber;
	private String taskId;
	
	private CountDownLatch doneCountDownLatch;
	
	@Override
	public void run() {
		boolean isRunningDaemonThread = Thread.currentThread().isDaemon();
		String threadType = isRunningDaemonThread? "DAEMON" : "USER";
		
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("###### [" + currentThreadName + "," + threadType+ "] < " + taskId + "> STARTING #####");
		
		for (int i=10; i>0; i--){
			
			System.out.println("[" + currentThreadName +  "] <" + taskId + ">TICK TICK " + i);
			
			try {
				TimeUnit.MILLISECONDS.sleep((long) Math.random() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		
		System.out.println("******* [" + currentThreadName + "] < " + taskId + "> DONE *******");
		
		if(doneCountDownLatch!=null){
			doneCountDownLatch.countDown();
			
			System.out.println("******* [" + currentThreadName + "] < " + taskId + ">"
					+ " LATCH COUNT =" + doneCountDownLatch.getCount());

		}
	
	}
	
	
	public LoopTaskI(CountDownLatch doneCountDownLatch){
		this.doneCountDownLatch=doneCountDownLatch;
		
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskI" + instanceNumber;
	}

}
