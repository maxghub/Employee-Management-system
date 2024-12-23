package in.ems.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ems.model.Employee;
import in.ems.repository.EmployeeRepository;

@Service
public class ReportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Report for Attendance
    public List<Employee> getAttendanceReport() {
        return employeeRepository.findByActiveSW("Y");
    }

    // Report for Salary
    public double getSalaryReport() {
        return employeeRepository.findByActiveSW("Y").stream()
            .mapToDouble(Employee::getSalary).sum();
    }

    // Report for Department-Wise Distribution
    public Map<String, Long> getDepartmentReport() {
        return employeeRepository.findByActiveSW("Y").stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }
    
    public List<Object[]> getSalariesAndEmployeeCountByDepartmentWithActiveStatus() {
        return employeeRepository.sumSalariesAndCountEmployeesByDepartmentWithActiveStatus();
    }
    


}
