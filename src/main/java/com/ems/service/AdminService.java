package com.ems.service;

import com.ems.entity.Admin;

public interface AdminService {

	void saveAdmin(Admin admin);
	boolean login(String userName, String password);
}
