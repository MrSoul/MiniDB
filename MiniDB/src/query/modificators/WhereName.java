package query.modificators;

import entities.*;
import query.*;

public class WhereName implements Requirement {

	String comparanda;
	boolean executable;

	public WhereName(String s) {
		comparanda = s;
	}

	public boolean execute(Human h) {
		boolean res = h.getName().equals(comparanda);
		return res;
	}

	@Override
	public void parseCommand(String command) {
		// TODO Auto-generated method stub
		String[] splits = command.split(" ");
		for (int i = 0; i < splits.length; i++) {
		if (splits[i].equals("where") && (splits[i + 1].equals("name"))) {
			String[] name = splits[i + 3].split("'");
				this.comparanda = name[1];
				this.executable = true;
				
		}
		}
		//	return false;
	}

	@Override
	public boolean canExecute() {
		// TODO Auto-generated method stub
		return false;
	}

}
