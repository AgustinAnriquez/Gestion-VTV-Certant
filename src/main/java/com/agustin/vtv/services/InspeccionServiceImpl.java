package com.agustin.vtv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agustin.vtv.dao.InspeccionDao;
import com.agustin.vtv.domain.Inspeccion;

@Service
public class InspeccionServiceImpl implements InspeccionService{

	@Autowired
	private InspeccionDao inspeccionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Inspeccion> listarInspecciones() {
		return (List<Inspeccion>) inspeccionDao.findAll();
	}

	@Override
	@Transactional
	public void guardarInspeccion(Inspeccion inspeccion) {
		inspeccionDao.save(inspeccion);
	}

	@Override
	@Transactional
	public void eliminarInspeccion(Inspeccion inspeccion) {
		inspeccionDao.delete(inspeccion);
	}

	@Override
	@Transactional(readOnly = true)
	public Inspeccion encontrarInspeccion(Inspeccion inspeccion) {
		return inspeccionDao.findById(inspeccion.getIdinspeccion()).orElse(null);
	}
	
}
