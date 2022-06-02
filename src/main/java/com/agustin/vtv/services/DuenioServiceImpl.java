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
	public Duenio guardarDuenio(Duenio duenio) {
		return duenioDao.save(duenio);
	}

	@Override
	@Transactional
	public boolean eliminarDuenio(Duenio duenio) {
		try {
		duenioDao.delete(duenio);
		return true;
		}catch(Exception err) {
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true) 
	public Duenio encontrarDuenio(Duenio duenio) {
		return duenioDao.findById(duenio.getDnipersona()).orElse(null);
	}

}
