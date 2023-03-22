package com.ems.serviceimpl;

import com.ems.dao.AdminDAO;
import com.ems.daoimpl.AdminDAOImpl;
import com.ems.entity.Admin;
import com.ems.service.AdminService;

public class AdminServiceImpl implements AdminService{

	AdminDAO adminDao = new AdminDAOImpl();
	
	@Override
	public void saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin);
		
	}

	@Override
	public boolean login(String userName, String password) {
		return adminDao.login(userName, password);
	}

}
