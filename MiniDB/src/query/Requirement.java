package query;

import entities.*;

public abstract class Requirement {
	boolean res = false;

	public boolean execute(Human h) {
		return res;
	}
}
