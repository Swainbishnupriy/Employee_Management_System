package com.ems.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.AdminDAO;
import com.ems.entity.Admin;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public void saveAdmin(Admin admin) {
		try(Session session= HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
			session.clear();
			
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public boolean login(String userName, String password) {
		try(Session session=HibernateUtil.getSession())
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ","Type here.."));
			Admin admin=session.get(Admin.class, id);
			if(admin.getUserName().equals(userName) && admin.getPassword().equals(password) 
					&& admin.getRole().equals("admin"))
			{
				JOptionPane.showMessageDialog(null, "Log In successfull!!");
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong Credentials!!");
				return false;
			}
		}
	}

}
