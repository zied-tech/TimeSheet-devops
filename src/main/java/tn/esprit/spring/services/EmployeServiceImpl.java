package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service

public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);
 	final String cnxdb = "connexion à la DB Ok :";
	@Override
	public List<Employe> retrieveAllEmployes() { 
		List<Employe> employes = null; 
		try {
			
			l.info("In Method retrieveAllEmployes :");
			employes = (List<Employe>) employeRepository.findAll(); 
			l.debug("connexion a la database OK : ..."); 
			for (Employe employe : employes) {
				l.debug("employe :" + employe.getNom()); 
			} 
			l.info("Out of Method retrieveAllEmployes with Success" + employes.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllEmployes with Errors : " + e); 
		}

		return employes;
	}


	@Override
	public Employe addEmploye(Employe e) {
		
		Employe e_saved = null; 
		
		try {
			l.info("In Method addEmploye :");
			e_saved = employeRepository.save(e); 
			l.debug(cnxdb); 
			
		} catch (Exception ex) {
			l.error("error in addEmploye() : " + ex);
		}
		
		return e_saved; 
	}

	@Override 
	public Employe updateEmploye(Employe e) {
		
		Employe employeUpdated = null; 
		
		try {
			l.info("In Method updateEmploye :"); 
			employeUpdated = employeRepository.save(e); 
			l.debug(cnxdb);  
			
		} catch (Exception ex) {
			l.error("error in updateEmploye() : " + e);
		}
		
		return employeUpdated; 
	}

	@Override
	public void deleteEmploye(String id) {
		
		try {
			l.info("In Method deleteEmploye :"); 
			employeRepository.deleteById(Long.parseLong(id)); 
			l.debug(cnxdb); 
			
		} catch (Exception e) {
			l.error("error in deleteEmploye() : " + e);
		}
		
	}

	@Override
	public Employe retrieveEmploye(String id) {
		Employe e = null; 
		try {
			l.info("In Method retrieveEmploye :"); 
			e =  employeRepository.findById(Long.parseLong(id)).get(); 
			l.debug(cnxdb); 
			
		} catch (Exception ex) {
			l.error("error in retrieveUEmploye() : " + ex);
		}

		return e; 
	}

}
