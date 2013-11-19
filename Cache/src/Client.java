import java.util.Random;


public class Client implements Runnable{

	private Random rand = new Random();
	private CacheMap cache;
	
	public Client(CacheMap cache) {
		// TODO Auto-generated constructor stub
		this.cache = cache;
	}

	public void run(){
		Integer key;
		while(true){
			key = rand.nextInt(100);
			System.out.println(cache.openPage(key.toString()));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
