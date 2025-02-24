package MVC_Practice.DAO;

import MVC_Practice.DTO.StudentDto;

public interface StudentDAO{
	void addStudent(String name,String username,String email,String pass);
	StudentDto getStudent(String email, String pass);
}

