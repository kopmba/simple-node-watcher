package dbstore.main.entity;

import java.io.IOException;
import java.util.Random;

import dbstore.connection.Util;
import wazcmd.WazCmd;

public class Store {
	
	private int storeId;
	private String username;
	private String password;
	private String name;
	private String pname;
	
	public Store(int id) {
		this.pname = Util.FILEPATH;
		this.storeId = id;
	}
	
	public Store(String url) throws IOException, InterruptedException {
		WazCmd cmd = new WazCmd();
		cmd.processCmd("cmd.exe", "/c echo ", url, " > ", Util.FILEPATH);
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPname() {
		return pname;
	}
	

}
