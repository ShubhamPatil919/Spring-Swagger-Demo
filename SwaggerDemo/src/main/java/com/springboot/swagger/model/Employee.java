package com.springboot.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Model Class Employee To add new Employee")
public @Data class Employee {

	@ApiModelProperty(notes = "Unique id for an employee in integer")
	private @Getter int empId;
	@ApiModelProperty(notes = "Name of employee")
	private String empName;
	@ApiModelProperty(notes = "Contact Number of employee")
	private long phoneNo;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	

}
