
package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

// employeRestControl
@RestController // = @Controller + @ResponseBody 
//@Scope("session") 
// singleton c'est par défaut 
// prototype 
// request 
//change
public class EmployeRestControl {

	// Couplage Faible 
	@Autowired 
	IEmployeService employeService; 
 
	// URL : http://localhost:????/????/retrieve-all-employes
	@GetMapping("/retrieve-all-employes")
	public List<Employe> retrieveAllEmployes() {
		List<Employe> list = employeService.retrieveAllEmployes();
		return list;
	}
 
	// http://localhost:????/timesheet-devops/retrieve-employe/{employe-id}
	@GetMapping("/retrieve-employe/{employe-id}")
	public Employe retrieveEmploye(@PathVariable("employe-id") String employeId) {
		return employeService.retrieveEmploye(employeId);
	}

	// Ajouter Employe : http://localhost:????/timesheet-devops/add-employe 
	@PostMapping("/add-employe")
	public Employe addEmploye(@RequestBody Employe e) {
		Employe employe = employeService.addEmploye(e); 
		return employe;
	}

	
	// Supprimer employe : 
	// http://localhost:????/timesheet-devops/remove-employe/{employe-id}
	@DeleteMapping("/remove-employe/{employe-id}") 
	public void removeEmploye(@PathVariable("employe-id") String employeId) { 
		employeService.deleteEmploye(employeId);
	} 

	// Modifier employe 
	// http://localhost:????/timesheet-devops/modify-employe 
	@PutMapping("/modify-employe") 
	public Employe updateEmploye(@RequestBody Employe employe) {
		return employeService.updateEmploye(employe);
	}
	 
} 
 
