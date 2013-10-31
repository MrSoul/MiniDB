package query.modificators;

import entities.*;
import query.*;

public class SelectByType implements Requirement {
	boolean executable = false;
	String comparanda;

	public SelectByType(String s) {
		comparanda = s;
	}

	public boolean execute(Human h) {
		boolean res = h.getNoteType().equals(comparanda);
		return res;
	}


	public void parseCommand(String command) {
		String[] splits = command.split(" ");

		for (int i = 0; i < splits.length; i++) {
			if (splits[i].equals("select")
					&& (splits[i + 1].equals("teacher") || splits[i + 1]
							.equals("student"))) {
				this.executable = true;
				this.comparanda = splits[i + 1];
			}
		}
	}

	public boolean canExecute() {
			return executable;
	}

}