package database;

import java.util.*;
import java.io.*;

public class Configuration {

	private static Configuration instance;
	private Properties prop = new Properties();

	private Configuration() {
		try {
			prop.load(new FileInputStream("config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Configuration instance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}

	public DBReaderFactory.SOURCE_FORMAT getSourceFormat() {
		DBReaderFactory.SOURCE_FORMAT source;
<<<<<<< HEAD

		if (prop.getProperty("containerType").equals("TXT")) {
			source = DBReaderFactory.SOURCE_FORMAT.TXT;
		} else {
			source = DBReaderFactory.SOURCE_FORMAT.XML;
		}

		//System.out.println(source.toString());
		return source;
=======
		if((prop.getProperty("containerType")) == "TXT")
			{ source = DBReaderFactory.SOURCE_FORMAT.TXT ;
			return source;
			}	else 
			{source = DBReaderFactory.SOURCE_FORMAT.XML;
				return source;}
		
>>>>>>> refs/heads/Feature-DTO
	}

	public String getFileName() {
		return prop.getProperty("inputfile");
	}

}
