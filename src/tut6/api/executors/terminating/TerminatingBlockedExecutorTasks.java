package tut6.api.executors.terminating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import tuts.common.FactorialTaskB;
import tuts.common.LoopTaskA;
import tuts.common.LoopTaskG;
import tuts.common.NamedThreadFactory;

public class TerminatingBlockedExecutorTasks {

	public static void main(String[] args) throws InterruptedException {
		
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");

		
		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
		

		LoopTaskA task1 = new LoopTaskA();
		LoopTaskG task2 = new LoopTaskG();
		FactorialTaskB task3 = new FactorialTaskB(30, 500);
		
		Future<?>  f1 = execService.submit(task1);
		Future<?>  f2 = execService.submit(task2);
		Future<?>  f3 = execService.submit(task3);
		
		execService.shutdown();
		
		
		TimeUnit.MILLISECONDS.sleep(2000);
		
		/**
		 * Note: 
		 *   Future.cancel(true) - cancels an already running thread
		 *   Future.cancel(false) - cancels a thread that has not been started yet   
		 */
		
		System.out.println("[" + currentThreadName + "] Invoking cancel() on all tasks ...");
        f1.cancel(true);
        f2.cancel(true);
        f3.cancel(true);
		
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
		
	}
	
}
