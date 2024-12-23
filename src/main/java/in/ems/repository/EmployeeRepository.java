package in.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.ems.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	
	// Find employees where activeSw is "Y"
    List<Employee> findByActiveSW(String activeSw);
    
    
    List<Employee> findByDepartment(String department);
    
    
    @Query("SELECT e.department, SUM(e.salary), COUNT(e.id) FROM Employee e WHERE e.activeSW = 'Y' GROUP BY e.department")
    List<Object[]> sumSalariesAndCountEmployeesByDepartmentWithActiveStatus();

}
