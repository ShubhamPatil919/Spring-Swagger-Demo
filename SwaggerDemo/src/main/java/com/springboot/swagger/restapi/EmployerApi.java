package com.springboot.swagger.restapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.swagger.model.Employer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@ApiModel(description = "Employeer Model Class")
@RestController("/api/employer")
public class EmployerApi {

	HashMap<String, Employer> employer = new HashMap<>();

	@GetMapping("/getEmployer")
	@ApiOperation(value = "Get Employeer Name and Details", notes = "Employeer Details", response = Employer.class)
	public List<Employer> getEmployer(@ApiParam(value = "Enter Employer id") @PathVariable int employerId) {
		return new ArrayList<Employer>(employer.values());
	}

}
