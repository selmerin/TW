import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Main {

	private static int ILOSC = 5;
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CacheMap cache = new CacheMap();
		Client c1 = new Client(cache);
		Client c2 = new Client(cache);
		//c1.start();
		//c2.start();
		
		ExecutorService executor = Executors.newFixedThreadPool(ILOSC);
		for(int i=0;i< ILOSC; i++){
			Runnable client = new Client(cache);
			executor.execute(client);
		}
		
	}

}
