package query.modificators;

import entities.*;
import java.util.*;

public class SortedByName implements Comparator<Human> {

	@Override
	public int compare(Human o1, Human o2) {
		String name1 = o1.getName();
		String name2 = o2.getName();
		int answer = name1.compareTo(name2);
		return answer;

	}

}
