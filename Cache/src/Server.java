
public class Server {
	
	private String p1 = "html><head><title>";
	private String p2 = "</title></head><body><p>";
	private String p3 = "</p></body></html>";


	public String getFromServer(String url){
		Long time = System.currentTimeMillis(); //czas w sekundach :)
		String page = p1;
		page = page.concat(url).concat(p2).concat(time.toString()).concat(p3);
		return page;

	}
}
