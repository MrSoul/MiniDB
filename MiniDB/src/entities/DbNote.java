package entities;

import java.util.*;

public abstract class DbNote {

	// Fields
	public static String NOTE_TYPE = "Type";
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private Date date;

	// Methods
	public void print() {
	}

	public String getNoteType() {
		return NOTE_TYPE;
	}

}
// Мы наследуемся от этого класса,т.к. у нас есть поля с одинаковым смыслом.
// потом при порождении объектов это позволит применить фабричный метод.