import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoinFlip2 implements Runnable {
	private final int loopLimit = 1000;
    private int min = 1; 
    private int range = 2;
    private int random;
    private int headcount = 0;
    
    public CoinFlip2() {
    	ExecutorService taskList = Executors.newFixedThreadPool(100);
		taskList.execute(this);
		taskList.execute(this);
		taskList.execute(this);
		taskList.execute(this);
		taskList.execute(this);
		taskList.shutdown();
    }

	public void run() {
		for(int i=0;i<loopLimit;i++) {
			random=(int)(Math.random() * range) + min;
			//head random = 1
			//tail random = 2
			if(random==1) {
				headcount++;
				if(headcount>=3) {
					String threadName = Thread.currentThread().getName();
					System.out.printf("%s: %s head Exercise 2\n", threadName, headcount );
				}
			}else {
				headcount = 0;
			}
		}
	}
}
