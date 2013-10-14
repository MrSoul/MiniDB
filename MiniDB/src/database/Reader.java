package database;

import java.text.*;
import java.util.*;
import entities.*;
import java.io.*;

public interface Reader {
	
	LinkedList<Human> readDatabase() throws IOException,ParseException;

}


