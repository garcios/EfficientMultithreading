package tut7.api.executors.exceptionHandling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tuts.common.ExceptionLeakingTask;
import tuts.common.ThreadExceptionHandler;
import tuts.common.ThreadFactoryWithExceptionHandlerAlternator;

public class HandlingExecutorUncaughtExceptions_DeafultsNOverrides {

	public static void main(String[] args) {
		
		
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");

		//global exception handler
		Thread.setDefaultUncaughtExceptionHandler( new ThreadExceptionHandler("DEFAULT_HANDLER"));
		
		ExecutorService execService = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandlerAlternator());
		
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		
		execService.shutdown();
		
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");

	}

}
