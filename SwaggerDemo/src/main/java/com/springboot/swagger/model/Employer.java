package com.springboot.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Employeer Model Class")
public class Employer {

	@ApiModelProperty(notes = "Employeer Id")
	private String emplotyeerId;
	@ApiModelProperty(notes = "Employeer Name")
	private String employeerName;

	public String getEmplotyeerId() {
		return emplotyeerId;
	}

	public void setEmplotyeerId(String emplotyeerId) {
		this.emplotyeerId = emplotyeerId;
	}

	public String getEmployeerName() {
		return employeerName;
	}

	public void setEmployeerName(String employeerName) {
		this.employeerName = employeerName;
	}

}