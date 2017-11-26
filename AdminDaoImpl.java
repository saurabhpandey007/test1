package com.rtgs.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rtgs.dao.AdminDao;
import com.rtgs.db.model.AdminDTO;



@Repository
@Transactional 
public class AdminDaoImpl implements AdminDao {
	
	
	
	public AdminDaoImpl() {
		super();
		
	}
@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public AdminDTO validateAdmin(String email, String pass) {

		return (AdminDTO) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select a from AdminDTO a where a.adminId = :em and a.password = :pass")
				.setParameter("em", email).setParameter("pass", pass)
				.uniqueResult();
	}
	

}
