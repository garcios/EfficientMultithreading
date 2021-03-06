package tuts.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskB implements Callable<TaskResults<String,Integer>> {

	
	private int a;
	private int b;
	private long sleepTime;
	
	private static int count =0;
	private int instanceNumber;
	private String taskId;
	
	
	public CalculationTaskB(int a, int b, long sleepTime){
		this.a =a;
		this.b=b;
		this.sleepTime=sleepTime;
		
		this.instanceNumber = ++count;
		this.taskId = "CalculationTaskB-" + instanceNumber;
		
		
	}
	
	@Override
	public TaskResults<String,Integer> call() throws Exception {
       String currentThreadName = Thread.currentThread().getName();
       
       System.out.println("###### [" + currentThreadName + "] < " + taskId + "> STARTING #####");
       System.out.println("###### [" + currentThreadName + "] < " + taskId + "> Sleeping for " + sleepTime + " millis");
       
 		TimeUnit.MILLISECONDS.sleep(sleepTime);
       
       
       System.out.println("******* [" + currentThreadName + "] < " + taskId + "> DONE *******");
       
       return new TaskResults<String,Integer>(taskId, a+b);
             
	}
	


}
