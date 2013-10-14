package database;

import javax.xml.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import entities.*;

import java.io.*;
import java.text.ParseException;
import java.util.LinkedList;

public class XmlReader implements Reader {
	
	private LinkedList<Human> data;
	private final Document doc;
	
	
	public XmlReader(String fileName) throws SAXException, IOException, ParserConfigurationException {
		
	data = new LinkedList<Human>();
	File fXmlFile = new File(fileName);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();
	}

	@Override
	public LinkedList<Human> readDatabase() throws IOException, ParseException {
		// TODO Auto-generated method stub
		final LinkedList<Element> sList = readEntity("Student");
		final LinkedList<Element> tList = readEntity("Student");
		
		for (Element e: sList){
			data.add(readStudent(e));
		}
		for (Element e: tList){
			data.add(readTeacher(e));
		}
	}

	private Human readTeacher(Element e) {
		// TODO Auto-generated method stub
		return null;
	}

	private Human readStudent(Element e) {
		// TODO Auto-generated method stub
		return null;
	}

}
