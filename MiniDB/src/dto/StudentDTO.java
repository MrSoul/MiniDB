package dto;

import java.util.*;

public class StudentDTO implements HumanDTO{

	public final String name;
	public final Date birthDate;
	public final String groupName;
	public final String faculty;
	
	public StudentDTO(String name, Date birthDate, String groupName, String faculty){
		this.name = name;
		this.birthDate = birthDate;
		this.groupName = groupName;
		this.faculty = faculty;
	}
	
}
