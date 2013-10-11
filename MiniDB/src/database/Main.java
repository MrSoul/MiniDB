package database;

import java.text.ParseException;
import java.util.*;
import java.io.*;
import query.*;

public class Main {
	
	public static void main(String... args) throws IOException, ParseException{ 
	
	//firstly, lets read our config file. 
	Properties prop = new Properties();
	try {
        //load a properties file
		prop.load(new FileInputStream("config.properties"));
				
	} catch (IOException ex) {
		ex.printStackTrace();
	}
		
		DatabaseReader DbR = new DatabaseReader(prop.getProperty("inputfile"));
		Scanner in = new Scanner(System.in);
	
	// Invitation
	System.out.println("Database system started. Waiting instructions...");
	do {
			System.out.print(">> ");
			String input = in.nextLine();
			if (input.equals("quit")) break;
			myQuery Q = new myQuery(input);
			Q.array_query(DbR.populate());
		} while (true);
	in.close();
	}
	
}
