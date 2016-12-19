package tuts.common;

public class ThreadFactoryWithExceptionHandler extends NamedThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t =  super.newThread(r);
		t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		
		return t;
	}
	
}
