package tn.esprit.spring;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.esprit.spring.services.EmployeServiceImpl;



@SpringBootApplication
public class TimesheetDevopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetDevopsApplication.class, args);
	}
	
	EmployeServiceImpl us=null;
	String string = "2015-03-20";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate date = LocalDate.parse(string, formatter);
	
	//commentair one
	//commentaire ttwo
	

	
	
}
