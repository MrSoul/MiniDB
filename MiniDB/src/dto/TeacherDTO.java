package dto;

import java.util.*;


public class TeacherDTO implements HumanDTO{

	public final String name;
	public final Date birthDate;
	public final String subject;
	
	public TeacherDTO(String name, Date birthDate, String subject){
		this.name = name;
		this.birthDate = birthDate;
		this.subject = subject;
	}
}
