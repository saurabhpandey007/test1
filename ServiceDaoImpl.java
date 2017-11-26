package com.rtgs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rtgs.dao.AdminDao;
import com.rtgs.dao.impl.AdminDaoImpl;
import com.rtgs.db.model.AdminDTO;
import com.rtgs.service.ServiceDao;

@Service("dao_based_service")
//mandatory
@Transactional
public class ServiceDaoImpl implements ServiceDao {

	
	
	@Autowired
	private AdminDao dao;
		
		
	@Override
	@Transactional(readOnly = true)
	public AdminDTO validateAdmin(String email, String pass) {
		// TODO Auto-generated method stub
		return dao.validateAdmin(email, pass);
	}
}
