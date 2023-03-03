package dbstore.connection;

import java.io.IOException;
import java.util.Set;

import dbstore.main.cache.CacheData;
import main.Entity;
import main.UtilFormat;
import wazcmd.WazCmd;

public class Util {
	
	public static final String FILEPATH = "";
	public static final String PNAME = "";
	public static final String[] DB_PROPERTIES = new String[] {};
	
	public static void saveJsonFile(CacheData cache, Entity e, Set list) throws IOException, InterruptedException {
		//store new data value
		cache.set(e.getClass().getName(), list);
		//save in json
		WazCmd cmd = new WazCmd();
		cmd.processCmd("cmd.exe", "/c echo ", UtilFormat.jsonFormatArrayObjectProperty(list));
	}

}
