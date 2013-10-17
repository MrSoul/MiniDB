package dto;

public class StudentDTO implements HumanDTO {

	public final String name;
	public final String birthDate;
	public final String groupName;
	public final String faculty;

	public StudentDTO(String name, String birthDate, String groupName,
			String faculty) {
		this.name = name;
		this.birthDate = birthDate;
		this.groupName = groupName;
		this.faculty = faculty;
	}

}
