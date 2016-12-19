package tut6.api.executors.terminating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import tuts.common.CalculationTaskC;
import tuts.common.LoopTaskF;
import tuts.common.NamedThreadFactory;

public class TerminatingExecutorTasksSecondWay {

	public static void main(String[] args) throws InterruptedException {
		
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");

		
		ExecutorService execService = Executors.newFixedThreadPool(2,new NamedThreadFactory());
		
		CalculationTaskC task1 = new CalculationTaskC();
		LoopTaskF task2 = new LoopTaskF();
		LoopTaskF task3 = new LoopTaskF();
		
		
		Future<Long>  f1 = execService.submit(task1);
		Future<?>  f2 = execService.submit(task2);
		Future<?>  f3 = execService.submit(task3);
		
		
		execService.shutdown();
		
		
		TimeUnit.MILLISECONDS.sleep(2000);
		
		/**
		 * Note: 
		 *   Future.cancel(true) - cancels an already running thread
		 *   Future.cancel(false) - cancels a thread that has not been started yet   
		 */
		
		System.out.println("[" + currentThreadName + "] Interrupting CalculationTaskC-1 ...");
		System.out.println("[" + currentThreadName + "] Cancelling f1 =..." +  f1.cancel(true));
		
		
		System.out.println("[" + currentThreadName + "] Interrupting LoopTaskF-1 ...");
		System.out.println("[" + currentThreadName + "] Cancelling f2 = ..." +  f2.cancel(true));
		
        //f3 will be cancelled because it has not been started yet because thread pool size is 2
		System.out.println("[" + currentThreadName + "] Interrupting LoopTaskF-2 ...");
		System.out.println("[" + currentThreadName + "] Cancelling f3 = ..." +  f3.cancel(false)); 

		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
		
	}
	
}
