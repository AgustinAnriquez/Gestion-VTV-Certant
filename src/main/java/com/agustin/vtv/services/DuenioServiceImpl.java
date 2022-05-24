package com.agustin.vtv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agustin.vtv.dao.DuenioDao;
import com.agustin.vtv.domain.Duenio;

@Service
public class DuenioServiceImpl implements DuenioService{

	@Autowired
	private DuenioDao duenioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Duenio> listarDuenios() {
		return (List<Duenio>) duenioDao.findAll();
	}

	@Override
	@Transactional
	public void guardarDuenio(Duenio duenio) {
		duenioDao.save(duenio);
		
	}

	@Override
	@Transactional
	public void eliminarDuenio(Duenio duenio) {
		duenioDao.delete(duenio);	
	}

	@Override
	@Transactional(readOnly = true) 
	public Duenio encontrarDuenio(Duenio duenio) {
		return duenioDao.findById(duenio.getDnipersona()).orElse(null);
	}

}
