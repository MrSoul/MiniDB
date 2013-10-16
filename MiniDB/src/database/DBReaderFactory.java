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
			
			SOURCE_FORMAT format = config.getSourceFormat();
			System.out.println(format.toString() + " before if");
			if(format == SOURCE_FORMAT.TXT){
				System.out.println("Txt reader created");
				return new PlainTextReader();
				}	else {
					System.out.println("XML reader created");
					return new XmlReader(config.getFileName());
				}
			
			
	}
}

