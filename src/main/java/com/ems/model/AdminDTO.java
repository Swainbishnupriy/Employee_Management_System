package com.ems.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminDTO extends UserDTO{

	private String adminName;
	private String adminEmail;
}
