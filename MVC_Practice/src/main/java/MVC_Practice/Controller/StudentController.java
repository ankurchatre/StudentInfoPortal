package MVC_Practice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import MVC_Practice.DAO.Student;
import MVC_Practice.DTO.StudentDto;


@Controller
public class StudentController{

	
	@GetMapping("/welcome")
	public String openWelcomePage() {	
		return "addStudentForm1";
	}
	 
	 @PostMapping("/studentform")
	    public String addStudent(
	    		@RequestParam("name") String name,
	    		@RequestParam("username") String username,
	    		@RequestParam("email") String email,
	    		@RequestParam("pass") String password
	    		) {
		 Student std = new Student();
		 std.addStudent(name, username, email, password);
			return "addStudentForm1";
	       
	    }
	 @GetMapping("/login")
	 public String loginPage() {
		 return "login";
	 }
	 @PostMapping("/login")
	 public ModelAndView getInformation(
	         @RequestParam("email") String email,
	         @RequestParam("password") String passString
	         ) {
	     Student student = new Student();
	     StudentDto std = student.getStudent(email, passString);
	     ModelAndView modelAndView = new ModelAndView();
	     if (std == null) {
	         modelAndView.setViewName("error");
	     } else {
	         modelAndView.setViewName("success");
	         modelAndView.addObject("std", std);
	         System.out.println(std.getName());
	         System.out.println(std.getUsername());
	         System.out.println(std.getEmail());
	         System.out.println(std.getPass());
	         
	     }
	     return modelAndView;
	 }
	
}
