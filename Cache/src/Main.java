

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CacheMap cache = new CacheMap();
		Client c1 = new Client(cache);
		Client c2 = new Client(cache);
		c1.start();
		c2.start();

		
	}

}
