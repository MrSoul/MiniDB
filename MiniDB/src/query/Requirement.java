package query;

import entities.*;

public interface Requirement {
		public boolean execute(Human h);
		public void parseCommand(String command);
		public boolean canExecute();
}
