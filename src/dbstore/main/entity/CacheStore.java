package dbstore.main.entity;

import java.util.HashMap;
import java.util.Map;

public class CacheStore {
	
	private int id;
	private Map<String, Object> mapper;
	
	public CacheStore(int id) {
		this.id = id;
		mapper = new HashMap<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Object> getMapper() {
		return mapper;
	}

	public void setMapper(Map<String, Object> mapper) {
		this.mapper = mapper;
	}

}
