package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class EmployeServiceImplTest {

@Autowired
IEmployeService es;

@Order(1)
@Test
public void testRetrieveAllEmployes(){
	List<Employe> employes = es.retrieveAllEmployes();
	Assertions.assertEquals(0,employes.size());
}

@Order(2)
//@Test
public void testAddEmploye() throws ParseException{
	
	
	Employe e = new Employe("Ali","Ben ahmed","ali.benahmed@telecom.tn",true,Role.ADMINISTRATEUR);
	Employe employeAdded = es.addEmploye(e);
	Assertions.assertEquals(e.getNom(),employeAdded.getNom());
}

@Order(3)
//@Test
public void testUpdateEmploye() throws ParseException{
	
	Employe e = new Employe("Ali","Ben ahmed","ali.benahmed@telecom.tn",true,Role.ADMINISTRATEUR);
	Employe employeUpdate = es.updateEmploye(e);
	Assertions.assertEquals(e.getNom(), employeUpdate.getNom());
}

@Order(4)
//@Test
public void testRetrieveEmploye(){
	Employe employeRetrieved = es.retrieveEmploye("2");
	Assertions.assertEquals(2L,employeRetrieved.getId());
}

@Order(5)
//@Test
public void testDeleteEmploye(){
	es.deleteEmploye("5");
	Assertions.assertNull(es.retrieveEmploye("5"));
}


	
}
