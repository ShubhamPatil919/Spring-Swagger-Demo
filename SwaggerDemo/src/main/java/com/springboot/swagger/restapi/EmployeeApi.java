package com.springboot.swagger.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.swagger.model.Employee;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class EmployeeApi {

	ConcurrentHashMap<Integer, Employee> emp = new ConcurrentHashMap<>();

	@GetMapping("/{empId}")
	//@ApiIgnore
	@ApiOperation(value = "Finds Employee with Id", notes = "Provide and find weather the Employee Exist", response = Employee.class)
	public Employee getEmployee(@ApiParam(value = "ID value must be an positive integer") @PathVariable int empId) {
		return emp.get(empId);

	}

	@GetMapping("/")
	@ApiResponses(value= {
	@ApiResponse(code=200,message="All Employees Retrived Successfully")})
	@ApiOperation(value = "Gets all Employee", notes = "Provide all the Employee Exist", response = Employee.class)
	public List<Employee> getAllEmployee() {
		return new ArrayList<Employee>(emp.values());
	}

	@PostMapping("/")
	@ApiResponses(value= {
	@ApiResponse(code=200,message="Employee Added Successfully") })
	@ApiOperation(value = "Add new employee", notes = "Provide the details and add employee", response = Employee.class)
	public Employee addEmployee(@RequestBody Employee employee) {
		emp.put(employee.getEmpId(), employee);
		return employee;
	}

}
