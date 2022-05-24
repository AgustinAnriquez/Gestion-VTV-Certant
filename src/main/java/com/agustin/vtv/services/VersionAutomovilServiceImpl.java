package com.agustin.vtv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agustin.vtv.dao.VersionAutomovilDao;
import com.agustin.vtv.domain.Version;

@Service
public class VersionAutomovilServiceImpl implements VersionAutomovilService{

	@Autowired
	private VersionAutomovilDao versionAutomovilDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Version> listarVersionAutomoviles() {
		return (List<Version>) versionAutomovilDao.findAll();
	}
	

}
