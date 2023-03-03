package dbstore.connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import dbstore.main.entity.Store;

public class Connection {
	
	private Store db;
	
	public Connection() throws IOException {
		db = new Store(retrieveId(readConnData()));
	}
	
	public Connection connect(String[] properties) throws IOException {
		
		for(int i = 0; i < properties.length; i++) {
			if(readConnData().contains(properties[i])) {
				continue;
			} else {
				return null;
			}
		}
		return this;
	}
	
	public String readConnData() throws IOException {
		File f = new File(Util.FILEPATH);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		StringBuilder sb = new StringBuilder();
		
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		return sb.toString();
	}
	
	private Integer retrieveId(String url) {
		String val = "";
		for(int i = 0; i < url.length(); i++) {
			if(url.charAt(i) != ':') {
				val += url.charAt(i);
			} else {
				return Integer.valueOf(val);
			}
		}
		return (Integer) null;
	}
	
	public Store getDb() {
		return db;
	}
	
	public void setDb(Store db) {
		this.db = db;
	}

}
