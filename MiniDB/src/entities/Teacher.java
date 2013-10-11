package entities;

import java.util.*;
public class Teacher extends Human{
	
	//Fields
	protected String NOTE_TYPE = "teacher";
	
	private String subject;	
	//Constructors
	public Teacher(String n, String d,String s){
	setName(n);
	setSubject(s);
	setBirthDate(d);
	}

	public Teacher(ArrayList<String> arr){
		setName (arr.get(1));
		setBirthDate(arr.get(2));
		setSubject (arr.get(3));
	}
	//Inheritance (override) methods
	
	public void print(){
		System.out.println(this.getName() +" " + this.getBirthDate().toString() + " " + subject);
	}
	// own getters and setters
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubject() {
		return subject;
	}
	public String getNoteType()
	{return NOTE_TYPE;}

}
