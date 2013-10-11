package query;

import java.util.*;

import query.modificators.*;
import entities.*;

enum SortType {
	byName, noSort, byDate
}

enum PrintType {
	simplePrint, age
}

public class myQuery {

	// fields
	private ArrayList<Requirement> reqs = new ArrayList<Requirement>();
	private SortType sortSwitcher = SortType.noSort;
	private PrintType outFormat = PrintType.simplePrint;

	public myQuery() {
	}

	public myQuery(ArrayList<Requirement> r) {
		reqs = r;
	}

	// Проверка единичного объекта
	public boolean execute_on(Human h)

	{
		if (reqs.isEmpty()) {
			return false;
		}
		for (Requirement req : reqs) {
			if (!req.execute(h)) {
				// System.out.println("фильтр не прошел выполнение");
				return false;
			}
			;
		}
		// System.out.println("фильтр прошел выполнение!");
		return true;
	}

	// Проверка массива объектов с выводом в другой массив, и какими-то
	// пост-действиями (вывод по , распечатка)
	public ArrayList<Human> array_query(LinkedList<Human> toCheck) {

		// Создадим массив для тех кто проходит фильтры
		ArrayList<Human> answer = new ArrayList<Human>();

		// В исходном массиве перебираем все элементы и каждый проверям, если
		// подходит - добавляем в результирующий массив
		for (Human human : toCheck) {
			if (this.execute_on(human)) {
				answer.add(human);
			}
		}
		// Пост обработка - Сортировка по каким-то параметрам, по умолчании -
		// без сортировки
		switch (sortSwitcher) {
		case byDate:
			Collections.sort(answer, new SortedByDate());
			break;
		case byName:
			Collections.sort(answer, new SortedByName());
			break;
		default:
			break;
		}

		// Пост обработка - модификаторы вывода. По умолчанию - просто печатаем.
		switch (outFormat) {
		case simplePrint:
			for (Human filtered : answer) {
				filtered.print();
			}
			break;
		case age:
			for (Human filtered : answer) {
				filtered.countAge();
			}
		}

		// В итоге все равно возвращаем результирующий массив (Вдруг мы захотим
		// потом джоины или группировки)
		return answer;
	}

	// Добавление нового фильтра в запрос
	public void add_requirement(Requirement r) {
		reqs.add(r);
	}

	// Конструктор, парсящий строку ввода пользователя.
	// Собсно, велосипед, состоящий из костылей c волшебными числами чуть менее
	// чем полностью
	// не успел разобраться с регекспами - пока работает просто как
	// метод-заглушка.
	public myQuery(String textQuery) {

		String[] splits = textQuery.split(" ");
		for (int i = 0; i < splits.length; i++) {

			// костыль select by type
			if (splits[i].equals("select")
					&& (splits[i + 1].equals("teacher") || splits[i + 1]
							.equals("student"))) {
				// System.out.println("!!!create select " + splits[i+1]);
				reqs.add(new SelectByType(splits[i + 1]));
			}
			// костыль where name
			if (splits[i].equals("where") && (splits[i + 1].equals("name"))) {
				String[] name = splits[i + 3].split("'");
				reqs.add(new WhereName(name[1]));
			}
			// костыль сортировки по дате
			if (splits[i].equals("order") && splits[i + 1].equals("by")
					&& splits[i + 2].equals("date")) {
				this.sortSwitcher = SortType.byDate;
			}
			// костыль сортировки по имени
			if (splits[i].equals("order") && splits[i + 1].equals("by")
					&& splits[i + 2].equals("name")) {
				this.sortSwitcher = SortType.byName;
			}
			// Костыль установки формата вывода, аналогично предыдущим.
			if (splits[i].equals("age") && splits[i + 1].equals("where")
					&& splits[i + 2].equals("name")) {
				this.sortSwitcher = SortType.byName;
				this.outFormat = PrintType.age;
			}
		}

	}
}
