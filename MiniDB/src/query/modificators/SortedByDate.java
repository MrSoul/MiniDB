package query.modificators;
import entities.*;
import java.util.*;

public class SortedByDate implements Comparator<Human> {

	@Override
	public int compare(Human o1, Human o2) {
		Date date1 = o1.getBirthDate();
		Date date2 = o2.getBirthDate();
		if(date1.getTime() > date2.getTime()) {
            return 1;
			}
     else if(date1.getTime() < date2.getTime()) {
            return -1;
     		}
     else {
            return 0;
		// TODO Auto-generated method stub
     		}
	
	}
}

