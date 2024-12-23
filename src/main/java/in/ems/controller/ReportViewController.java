package in.ems.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ems.model.Employee;
import in.ems.service.ReportService;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ReportViewController {

    @Autowired
    private ReportService reportService;

    // View for the attendance report
    @GetMapping("/view/attendance")
    public String getAttendanceReport(Model model) {
        List<Employee> attendanceReport = reportService.getAttendanceReport();
        model.addAttribute("attendanceReport", attendanceReport);
        return "attendance";  // Thymeleaf template name
    }

    // View for the salary report
    @GetMapping("/view/salary")
    public String getSalaryReport(Model model) {
        double totalSalary = reportService.getSalaryReport();
        model.addAttribute("totalSalary", totalSalary);
        return "salary";  // Thymeleaf template name
    }

    // View for the department-wise distribution report
    @GetMapping("/view/department")
    public String getDepartmentReport(Model model) {
        Map<String, Long> departmentReport = reportService.getDepartmentReport();
        model.addAttribute("departmentReport", departmentReport);
        return "department";  // Thymeleaf template name
    }
    
    @GetMapping("/salary-sum-department")
    public String getSalarySumAndEmployeeCountByDepartment(Model model) {
//        List<Object[]> salaryReport = reportService.getSalariesAndEmployeeCountByDepartmentWithActiveStatus();
//        model.addAttribute("salaryReport", salaryReport);
//        return "salary-sum-department";
    	
    	List<Object[]> salaryReport = reportService.getSalariesAndEmployeeCountByDepartmentWithActiveStatus();
    	salaryReport.forEach(entry -> entry[1] = String.format("%.2f", entry[1]));
    	model.addAttribute("salaryReport", salaryReport);
    	return "salary-sum-department";

    }
}


