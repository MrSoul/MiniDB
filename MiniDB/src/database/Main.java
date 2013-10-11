package database;

import java.text.ParseException;
import java.util.*;
import java.io.*;
import query.*;

public class Main {
	
	public static void main(String... args) throws IOException, ParseException{ 
	Scanner in = new Scanner(System.in);
	String input = in.nextLine();
	myQuery Q = new myQuery(input);
	DatabaseReader DbR = new DatabaseReader("DB.txt");
	Q.array_query(DbR.populate());
	in.close();
	}
}
