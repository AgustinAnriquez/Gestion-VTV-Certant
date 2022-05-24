package com.agustin.vtv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agustin.vtv.dao.AutomovilDao;
import com.agustin.vtv.domain.Automovil;

@Service
public class AutomovilServiceImpl implements AutomovilService{

	@Autowired
	private AutomovilDao automovilDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Automovil> listarAutomoviles() {
		return (List<Automovil>) automovilDao.findAll();
	}

	@Override
	@Transactional
	public void guardarAutomovil(Automovil automovil) {
		automovilDao.save(automovil);
	}

	@Override
	@Transactional
	public void eliminarAutomovil(Automovil automovil) {
		automovilDao.delete(automovil);
	}

	@Override
	@Transactional(readOnly = true)
	public Automovil encontrarAutomovil(Automovil automovil) {
		return automovilDao.findById(automovil.getDominio()).orElse(null);
	}
	
	
}
