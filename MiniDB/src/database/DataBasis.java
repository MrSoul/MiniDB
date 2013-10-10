package database;

import java.io.*;
import java.util.*;

import entities.*;
import query.*;

enum TypeSwitch {
	Teacher, Student
}

public class DataBasis {

	public static void main(String[] args) {

		// TODO цикличный Ввод с консоли и пробег по массиву

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();

		// Парсим ввод пользователя в запрос
		myQuery Q = new myQuery(input);

		// Кэшируем нашу базу в память из файла, и тут же применяем к нему наш
		// запрос.
		// По хорошему, нужно было делать "ленивое" чтение-проверку по одному
		// объекту, т.к. файлик может быть и больше гига, но погряз
		Q.array_query(populate("DB.txt"));

		// Конец.
	}

	@SuppressWarnings({ "static-access", "resource" })
	public static LinkedList<Human> populate(String fileName) {
		ArrayList<String> strings = new ArrayList<String>();
		LinkedList<Human> people = new LinkedList<Human>();
		BufferedReader reader;
		String noteType;
		TypeSwitch typeSwitcher = null;
		String line = System.getProperty("user.dir");
		// System.out.println(line);
		try {

			reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) { // Читаем до конца
															// файла
				while (!line.equals("-")) // Читаем до маркера разделителя
				{
					strings.add(line);
					line = reader.readLine();
				}

				noteType = strings.get(0);
				// Блок сравнения
				if (noteType.equals("Teacher"))
					typeSwitcher = typeSwitcher.Teacher;
				if (noteType.equals("Student"))
					typeSwitcher = typeSwitcher.Student;
				switch (typeSwitcher) {
				
				case Teacher:
					people.add(new Teacher(strings));
					break;

				case Student:
					people.add(new Student(strings));
					break;

				default:
					throw new IllegalStateException();
				}

				strings.clear(); // Чистим временный массив для построения
									// единичного объекта.
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return people;

	}
}
