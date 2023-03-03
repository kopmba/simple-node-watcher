package dbstore.main.dao;

import java.io.IOException;
import java.util.List;

import main.Entity;

public interface StoreDao<T> {
	
	public void add(Entity<T> e) throws IOException, InterruptedException;
	
	public void update(Entity<T> e, String id) throws IOException, InterruptedException;
	
	public void delete(String id) throws IOException, InterruptedException;;
	
	public List<Entity<T>> find() throws IOException, InterruptedException;
	
	public List<Entity<T>> filter(String id) throws IOException, InterruptedException;
	
	public Entity<T> findById(String id) throws IOException, InterruptedException;

}
