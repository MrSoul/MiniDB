package entities;

import java.text.*;
import java.util.*;

public abstract class Human extends DbNote {

	public static String NOTE_TYPE = "Human";
	private String name;
	private Date birthDate;

	// Methods
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBirthDate(String birthDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");

		try {
			this.birthDate = sdf.parse(birthDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getNoteType() {
		return "Human";
	}

	public void countAge() {
		Calendar dob = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		dob.setTime(birthDate);
		// include day of birth
		dob.add(Calendar.DAY_OF_MONTH, -1);

		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		System.out.println(age);
	}
}
