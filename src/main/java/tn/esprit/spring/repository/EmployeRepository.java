package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Employe;

@Repository
public interface EmployeRepository extends  CrudRepository<Employe, Long> { 
	 
}
 




















// List<Employe> findByFirstName(String prenom);
// List<Employe> findByLastName(String nom);
// List<Employe> findByIdGreaterThan(int nom);
	
//	@Query("SELECT MAX((e.id), 0) FROM Employe e") 
//	Long getMaxId(); 
	
//	// JPQL Update : 
//	@Modifying
//	@Query("update Employe e set e.role = :role where e.firstName = :prenom")
//	int updateEmployeStatusForFirstName(@Param("role") Integer status, @Param("prenom") String prenom);

	// Native Update : 
//	@Modifying
//	@Query(value = "update Employe e set e.status = ? where e.name = ?", nativeQuery = true)
//	int updateEmployeStatusForFirstName1(Integer status, String name);
	
//	@Modifying
//	@Query(value = "insert into Employes (firstName, lastName, role) values (:fn, :ln, :role)", nativeQuery = true)
//	void insertEmploye(@Param("fn") String fn, @Param("ln") Integer ln, @Param("role") Integer role);
