import java.util.concurrent.ConcurrentHashMap;


public class CacheMap {
	
	private int TIME = 10;
	private int LIMIT = 10;
	private int actualization = 0;
	private ConcurrentHashMap<String,  CacheObject> cachMap= new ConcurrentHashMap<>(); 
	private Server server = new Server();
	
	private void actualizations(){
		//System.out.println("sprawdzanie cachu");
		for(ConcurrentHashMap.Entry<String, CacheObject> it : cachMap.entrySet()){
			String key = it.getKey();
			CacheObject value = it.getValue();
			if(System.currentTimeMillis()/1000 - value.timeDownload > TIME){
				cachMap.remove(key);	
			}
					
		}
		actualization = 0;
	}
	
	public String openPage(String url){
		
		CacheObject currentObject;
		
		currentObject = cachMap.get(url);
		if(currentObject == null){ //przypadek jak nie ma obiektu w mapie
			currentObject = new CacheObject();
			currentObject.page = server.getFromServer(url);
			currentObject.timeDownload = System.currentTimeMillis()/1000; //czas w sekundach :)
			cachMap.put(url, currentObject);
			return currentObject.page;
		}
		if(System.currentTimeMillis()/1000 - currentObject.timeDownload <= TIME){ //czas mniejszy od 100 sekund
			return currentObject.page;
		}
		else if(System.currentTimeMillis()/1000 - currentObject.timeDownload > TIME){ //czas większy od 100 sekund
			System.out.println("aktualizacja");
			actualization++;
			if(actualization >= LIMIT)
				this.actualizations();
			currentObject.page = server.getFromServer(url);
			cachMap.put(url, currentObject);
			return currentObject.page;
		}
		
		return null;
	}
	
	

}
