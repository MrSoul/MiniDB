package query.modificators;

import entities.*;
import query.*;

public class WhereName implements Requirement {

	String Comparanda;

	public WhereName(String s) {
		Comparanda = s;
	}

	public boolean execute(Human h) {
		boolean res = h.getName().equals(Comparanda);
		return res;
	}

}
