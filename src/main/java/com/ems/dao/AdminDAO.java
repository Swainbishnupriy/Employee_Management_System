package com.ems.dao;

import com.ems.entity.Admin;

public interface AdminDAO {

	void saveAdmin(Admin admin);
	boolean login(String userName, String password);
}
