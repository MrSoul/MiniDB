package database;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import entities.*;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class XmlReader implements Reader {
	
	private LinkedList<Human> data;
	private final Document doc;
	
	
	public XmlReader() throws SAXException, IOException, ParserConfigurationException {
	final Configuration config = Configuration.instance();	
	data = new LinkedList<Human>();
	File fXmlFile = new File(config.getFileName());
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();
	}

	@Override
	public LinkedList<Human> readDatabase() throws IOException, ParseException {
		// TODO Auto-generated method stub
		final List<Element> sList = readEntity("Student");
		final List<Element> tList = readEntity("Teacher");
		
		for (Element e: sList){
			data.add(readStudent(e));
		}
		for (Element e: tList){
			data.add(readTeacher(e));
		}
		return data;
	}

	private List<Element> readEntity(String name){
		final NodeList nList = doc.getElementsByTagName(name);
		final ArrayList<Element> result = new ArrayList<Element>();
		
		for (int i=0; i < nList.getLength(); i++){
			Node nNode = nList.item(i);
			if (nNode.getNodeType()==Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				result.add(eElement);
			}
		}
		return result;
	}

	private String getText(Element e, String name){
		return e.getElementsByTagName(name).item(0).getTextContent();
	}
	
	private Student readStudent(Element e){
		ArrayList<String> init = new ArrayList<String>();
		init.add("student");
		init.add(getText(e,"name"));
		init.add(getText(e,"birthDate"));
		init.add(getText(e,"groupName"));
		init.add(getText(e,"faculty"));
		 return new Student(init);
	}
	
	private Teacher readTeacher(Element e){
		ArrayList<String> init = new ArrayList<String>();
		init.add("teacher");
		init.add(getText(e,"name"));
		init.add(getText(e,"birthDate"));
		init.add(getText(e,"subject"));
		return new Teacher(init);
	}
}
