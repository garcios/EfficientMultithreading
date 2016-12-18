package tut4.api.threads.daemonThreads;

import tuts.common.LoopTaskD;

public class DaemonThreads {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread t1 = new Thread(new LoopTaskD(500),"Thread-1");
        Thread t2 = new Thread(new LoopTaskD(1000),"Thread-2");
        
        //Daemon threads will be killed abruptly by the JVM as soon as no user threads are running
        //Since t1 and main threads will finished first, t2 will not finish its execution.
        t2.setDaemon(true); 
        
        t1.start();
        t2.start();
        
		System.out.println("[" + currentThreadName + "] Main thread ends here...");

		
	}
	
}
