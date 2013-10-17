package entities;

import java.util.*;

import dto.StudentDTO;

public class Student extends Human {

	// Fields
	protected static String NOTE_TYPE = "student";
	private int group;
	private String faculty;

	// Constructors
	public Student(String n, String d, int g, String f) {
		setName(n);
		setBirthDate(d);
		setGroup(g);
		setFaculty(f);
	}

	public Student(ArrayList<String> arr) {
		setName(arr.get(1));
		setBirthDate(arr.get(2));
		setGroup(Integer.parseInt(arr.get(3)));
		setFaculty(arr.get(4));
	}

	public Student(StudentDTO dto) {
		setName(dto.name);
		setBirthDate(dto.birthDate);
		setGroup(Integer.parseInt(dto.groupName));
		setFaculty(dto.faculty);

	}

	// Inheritance overrided methods
	public void print() {
		System.out.println(this.getName() + " "
				+ this.getBirthDate().toString() + " " + group + " " + faculty);
	}

	// Own getters and setters

	public void setGroup(int group) {
		this.group = group;
	}

	public int getGroup() {
		return group;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getFaculty() {
		return faculty;
	}

	public String getNoteType() {
		return NOTE_TYPE;
	}

}
