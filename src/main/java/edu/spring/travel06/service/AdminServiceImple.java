package edu.spring.travel06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.persistance.*;

@Service
public class AdminServiceImple implements AdminService
{
	private static final Logger logger = 
			LoggerFactory.getLogger(AdminServiceImple.class);
	
	@Autowired
	private AdminDAO adminDao;

	
	@Override
	public List<AdminVO> read() 
	{
		logger.info("관리자 read() 호출");
		return adminDao.select();
	}

	@Override
	public int create(AdminVO avo) 
	{
		logger.info("Administer create() 호출");
		return adminDao.insert(avo);
	}

	@Override
	public int update(AdminVO avo) 
	{
		logger.info("adminService update : " + avo.toString());
		return adminDao.update(avo);
	}

	@Override
	public int delete(String adminID) 
	{
		logger.info("adminService delete : " + adminID);
		adminDao.delete(adminID);
		return 1;
	}

	@Override
	public AdminVO read(String adminID) 
	{
		logger.info("adminService : " + adminID);
		return adminDao.select(adminID);
	}
	
	
	
	
	
}
