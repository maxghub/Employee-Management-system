package in.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ems.model.Employee;
import in.ems.repository.EmployeeRepository;




@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> getAllEmpRecords() {
		
		List<Employee> findAll = repo.findByActiveSW("Y");
		
		findAll.forEach(System.out::println);
		
		return findAll;
	}

	
	public boolean saveEmployee(Employee employee) {
		 employee.setActiveSW("Y");
		 Employee save = repo.save(employee);
		 if(save.getId()!=null) {
		 return true;
		 }
		 return false;
	}
	
	
	//delete the employe record
	public void deletedEmp(Integer id) {
		
		//Hard delete
		//repo.deleteById(id);
		
		
		//Soft delete
		Optional<Employee> findById = repo.findById(id);
		if(findById.isPresent()) {
			Employee e=findById.get();
			e.setActiveSW("N");
			repo.save(e);
		}	
	}
	
	
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> findById = repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

}
