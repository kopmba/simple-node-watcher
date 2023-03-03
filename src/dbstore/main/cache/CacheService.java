package dbstore.main.cache;

public interface CacheService {
	
	public void set(String key, Object value);
	
	public Object get(String key);
	
	public void remove(String key);
	
	public void removeAll();

}
