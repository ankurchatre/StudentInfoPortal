package MVC_Practice.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
@Table (name = "Student_Details")
public class StudentDto {
	public StudentDto() {
		
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	
	private String email;
	
	
	private String pass;
	
	
	private String username;
	
	
	

}
