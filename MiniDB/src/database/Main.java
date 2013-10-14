package database;

import java.text.ParseException;
import java.util.*;
import java.io.*;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import entities.*;
import query.*;

public class Main {
	
	public static void main(String... args) throws IOException, ParseException, SAXException, ParserConfigurationException{ 
	
		final Reader dbReader = DBReaderFactory.instance.getReader();
		LinkedList<Human> data = dbReader.readDatabase();
		
		Scanner in = new Scanner(System.in);
	
	// Invitation
	System.out.println("Database system started. Waiting instructions...");
	do {
			System.out.print(">> ");
			String input = in.nextLine();
			if (input.equals("quit")) break;
			myQuery Q = new myQuery(input);
			Q.array_query(data);
		} while (true);
	in.close();
	}
	
}
