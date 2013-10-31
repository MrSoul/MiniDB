package query.modificators;

import entities.*;
import query.*;

public class SelectByType implements Requirement {
	boolean res = false;
	String Comparanda;

	public SelectByType(String s) {
		Comparanda = s;
	}

	public boolean execute(Human h) {
		res = h.getNoteType().equals(Comparanda);
		return res;
	}


	public boolean parseCommand(String command) {
		String[] splits = command.split(" ");
		
		for (int i = 0; i < splits.length; i++) {
			if (splits[i].equals("select") && (splits[i + 1].equals("teacher") || splits[i + 1].equals("student"))) {
			return true;}
			}
		return false;
	}

}