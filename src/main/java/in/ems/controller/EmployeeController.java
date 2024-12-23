package in.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import in.ems.model.Employee;
import in.ems.service.EmployeeServiceImpl;



@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;
	
	@GetMapping("/employees")
	public ModelAndView getAll() {
		
		ModelAndView mav=new ModelAndView();
		List<Employee> allEmpRecords = service.getAllEmpRecords();
		mav.addObject("employees" ,allEmpRecords);
		
		mav.setViewName("index");
		
		return mav;
	}
	
	
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("employee",new Employee());
		mav.setViewName("add-form");
		
		return mav;
	
	}
	
	
	@PostMapping("/employee")
	public ModelAndView savedEmployee(Employee e) {
		ModelAndView mav=new ModelAndView();
	
		boolean status = service.saveEmployee(e);
		if(status) {
			mav.addObject("succMsg","Saved record");
		}
		else {
			mav.addObject("errMsg","record not save yet");
		}
		
		mav.setViewName("add-form");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteEmpRecord(@RequestParam("id") Integer id) {
		service.deletedEmp(id);
		ModelAndView mav=new ModelAndView();
		List<Employee> records = service.getAllEmpRecords();
		mav.addObject("employees", records);
		mav.setViewName("index");
		
		return mav;
	}
	
	
	@GetMapping("/edit")
	public ModelAndView editEmployee(@RequestParam("id") Integer id) {
		
		Employee employeeById = service.getEmployeeById(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("employee", employeeById);
		mav.setViewName("add-form");
		
		return mav;
	}
	
	@GetMapping("/employee_details")
	public ModelAndView detailsEmp() {
		ModelAndView mav=new ModelAndView();
		List<Employee> records = service.getAllEmpRecords();
		mav.addObject("employees", records);
		mav.setViewName("home");
		
		return mav;
		
		
	}
}
