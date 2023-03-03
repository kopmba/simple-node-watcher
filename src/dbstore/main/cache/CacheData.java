package dbstore.main.cache;

import dbstore.main.entity.CacheStore;

public class CacheData implements CacheService {
	
	CacheStore cache;
	
	public CacheData(CacheStore cache) {
		this.cache = cache;
	}

	@Override
	public void set(String key, Object value) {
		cache.getMapper().put(key, value);
	}

	@Override
	public Object get(String key) {
		return cache.getMapper().get(key);
	}

	@Override
	public void remove(String key) {
		cache.getMapper().remove(key);
	}

	@Override
	public void removeAll() {
		cache.getMapper().clear();
	}
	
	

}
