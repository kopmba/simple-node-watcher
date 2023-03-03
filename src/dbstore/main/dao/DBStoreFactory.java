package dbstore.main.dao;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dbstore.connection.Connection;
import dbstore.connection.Util;
import dbstore.main.cache.CacheData;
import dbstore.main.entity.CacheStore;
import main.Entity;
import main.UtilFormat;
import wazcmd.WazCmd;

public class DBStoreFactory<T> implements StoreDao<T> {
	
	Connection conn;
	Set<Entity> list;
	CacheData cacheData;
	Entity<T> entity;
	
	public DBStoreFactory() throws IOException {
		conn = new Connection();
		cacheData = new CacheData(new CacheStore(conn.getDb().getStoreId()));
		
	}

	@Override
	public void add(Entity<T> e) throws IOException, InterruptedException {
		conn.connect(Util.DB_PROPERTIES);
		if(conn != null) {
			if(cacheData.get(e.getClass().getName()) == null) {
				list.add(e);
				//Store in cache
				cacheData.set(e.getClass().getName(), list);
				//save json
				WazCmd cmd = new WazCmd();
				cmd.processCmd("cmd.exe", "/c echo ", UtilFormat.jsonFormatArrayObjectProperty(list));
			} else {
				Set newList = (Set) cacheData.get(e.getClass().getName());
				newList.add(e);
				//remove data in cache
				cacheData.remove(e.getClass().getName());
				Util.saveJsonFile(cacheData, e, newList);
			}
		}
	}

	@Override
	public void update(Entity<T> e, String id) throws IOException, InterruptedException {
		conn.connect(Util.DB_PROPERTIES);
		if(conn != null) {
			if(cacheData.get(e.getClass().getName()) == null) {
				System.err.print("No data in db");
				return;
			} else {
				Set newList = (Set) cacheData.get(e.getClass().getName());
				//remove data in cache
				cacheData.remove(e.getClass().getName());
				//edit the data
				for(int i = 0; i < newList.toArray().length; i++) {
					Entity entity = (Entity) newList.toArray()[i];
					//check if the id is the same and edit
					//that method have to be refactoring because of the error with WazJson api.
					//edit the data
				}
				Util.saveJsonFile(cacheData, e, newList);
			}
		}
		
	}

	@Override
	public void delete(String id) throws IOException, InterruptedException {
		conn.connect(Util.DB_PROPERTIES);
		if(conn != null) {
			if(cacheData.get(entity.getClass().getName()) == null) {
				System.err.print("No data to delete");
				return;
			} else {
				Set newList = (Set) cacheData.get(entity.getClass().getName());
				//remove data in cache
				cacheData.remove(entity.getClass().getName());
				//edit the data
				for(int i = 0; i < newList.toArray().length; i++) {
					Entity entity = (Entity) newList.toArray()[i];
					//check if the id is the same and remove
					//that method have to be refactoring because of the error with WazJson api.
					//remove the data
				}
				Util.saveJsonFile(cacheData, (Entity) entity, newList);
			}
		}
		
	}

	@Override
	public List<Entity<T>> find() throws IOException {
		
		conn.connect(Util.DB_PROPERTIES);
		if(conn != null) {
			if(cacheData.get(entity.getClass().getName()) == null) {
				System.err.print("No data in db!");
				return null;
			} else {
				return (List<Entity<T>>) cacheData.get(entity.getClass().getName());
				
			}
		}
		return null;
	}

	@Override
	public List<Entity<T>> filter(String id) throws IOException, InterruptedException {
		conn.connect(Util.DB_PROPERTIES);
		if(conn != null) {
			if(cacheData.get(entity.getClass().getName()) == null) {
				System.err.print("No data in db");
				return null;
			} else {
				Set newList = (Set) cacheData.get(entity.getClass().getName());
				//remove data in cache
				cacheData.remove(entity.getClass().getName());
				//filter the data
				Set result = new HashSet();
				for(int i = 0; i < newList.toArray().length; i++) {
					Entity entity = (Entity) newList.toArray()[i];
					//check if the id is the same that id and add to a new set
					//that method have to be refactoring because of the error with WazJson api.
					//add the data in the result set
				}
				Util.saveJsonFile(cacheData, entity, result);
			}
		}
		return null;
	}

	@Override
	public Entity<T> findById(String id) throws IOException {
		conn.connect(Util.DB_PROPERTIES);
		if(conn != null) {
			if(cacheData.get(entity.getClass().getName()) == null) {
				System.err.print("No data in db!");
				return null;
			} else {
				Set newList = (Set) cacheData.get(entity.getClass().getName());
				//Retrieve the corresponding data
				//that method have to be refactoring because of the error with WazJson api.
				//return the entity
			}
		}
		return null;
	}
	
	

}
