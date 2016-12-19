package tut8.api.executors.joinig;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tuts.common.LoopTaskI;
import tuts.common.NamedThreadFactory;

public class JoiningExecutorsThread {

	public static void main(String[] args) {
		
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");

		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
		
		CountDownLatch doneSignal = new CountDownLatch(2);

		execService.execute(new LoopTaskI(null)); //main thread will not wait for this to complete
		execService.execute(new LoopTaskI(doneSignal)); //main thread will wait for this to finish
		execService.execute(new LoopTaskI(doneSignal)); //main thread will wait for this to finish
		execService.execute(new LoopTaskI(null)); //main thread will not wait for this to complete
		
		execService.shutdown();
		
		try{
			doneSignal.await(); //wait for thread 2 and 3
			System.out.println("[" + currentThreadName + "] " + currentThreadName  +
					" GOT THE SIGNAL TO CONTINUE ...");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");

		
	}
	
}
