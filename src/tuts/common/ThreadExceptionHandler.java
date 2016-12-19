package tuts.common;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadExceptionHandler implements UncaughtExceptionHandler{

	private String handlerId;
	
	public ThreadExceptionHandler(String handlerId) {
		this.handlerId = handlerId;
	}
	
	public ThreadExceptionHandler() {
		
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		
		System.out.println(this + "caught Exception in thread -\"" +
		  t.getName() + "\" => " + e );
		
		
	}

	@Override
	public String toString() {
		return "ThreadExceptionHandler@" + this.hashCode()  + "[handlerId=" + handlerId + "]";
	}

	
	
}
