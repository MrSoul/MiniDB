package dto;

public class StudentDTOBuilder {
	
	//fields
	private String name;
	private String birthDay;
	private String groupName;
	private String faculty;
	
	//methods
	
	public StudentDTOBuilder name(String name){
		this.name = name;
		return this;
	
	}
	
	public StudentDTOBuilder birthday(String birthDay){
		this.birthDay = birthDay;
		return this;
	
	}
	
	public StudentDTOBuilder groupName(String groupName){
		this.groupName = groupName;
		return this;
	
	}
	
	public StudentDTOBuilder faculty(String faculty){
		this.faculty = faculty;
		return this;
	
	}
	public StudentDTO build(){
		
	return new StudentDTO(name, birthDay,groupName, faculty);
	}
}
