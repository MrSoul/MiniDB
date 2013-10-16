package database;

import java.io.*;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class DBReaderFactory {
	public static enum SOURCE_FORMAT {
		 TXT,
		 XML
	}
	private DBReaderFactory() {}
	
	public static final DBReaderFactory instance = new DBReaderFactory();
	
		private Configuration config = Configuration.instance();
		
		
		public Reader getReader() throws IOException, SAXException, ParserConfigurationException{
			
<<<<<<< HEAD
			if(config.getSourceFormat() == SOURCE_FORMAT.TXT){
=======
			SOURCE_FORMAT format = config.getSourceFormat();
			System.out.println(format.toString() + " before if");
			if(format == SOURCE_FORMAT.TXT){
				System.out.println("Txt reader created");
>>>>>>> refs/heads/Feature-DTO
				return new PlainTextReader();
				}	else {
<<<<<<< HEAD
				return new XmlReader();
=======
					System.out.println("XML reader created");
					return new XmlReader(config.getFileName());
>>>>>>> refs/heads/Feature-DTO
				}
			
			
	}
}

