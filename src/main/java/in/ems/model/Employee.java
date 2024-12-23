

package in.ems.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="employee_records_ems")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    private String email;
    
    private Integer attendanceDays;

    public Integer getAttendanceDays() {
		return attendanceDays;
	}

	public void setAttendanceDays(Integer attendanceDays) {
		this.attendanceDays = attendanceDays;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", attendanceDays=" + attendanceDays
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", activeSW=" + activeSW + ", salary="
				+ salary + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	    private LocalDate dateOfBirth;

    @NotBlank(message = "Department is mandatory")
    private String department;
       
    private String activeSW;
    // Getters and Setters

	public String getActiveSW() {
		return activeSW;
	}

	public void setActiveSW(String activeSW) {
		this.activeSW = activeSW;
	}
	
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
