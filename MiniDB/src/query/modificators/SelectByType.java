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
		// System.out.println(h.getNoteType() + " " + Comparanda );
		return res;
	}

}