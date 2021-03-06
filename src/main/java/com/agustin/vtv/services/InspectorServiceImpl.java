package com.agustin.vtv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agustin.vtv.dao.InspectorDao;
import com.agustin.vtv.domain.Inspector;

@Service
public class InspectorServiceImpl implements InspectorService{

	@Autowired
	private InspectorDao inspectorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Inspector> listarInspectores() {
		return (List<Inspector>) inspectorDao.findAll();
	}

	@Override
	@Transactional
	public Inspector guardarInspectores(Inspector inspector) {
		return inspectorDao.save(inspector);
	}

	@Override
	@Transactional
	public boolean eliminarInspector(Inspector inspector) {
		try {
		inspectorDao.delete(inspector);
		return true;
		}catch(Exception err) {
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Inspector encontrarInspector(Inspector inspector) {
		return inspectorDao.findById(inspector.getDnipersona()).orElse(null);
	}

	@Override
	public Inspector findByLegajo(@Param("legajo") String legajo) {
		return inspectorDao.findByLegajo(legajo);
	}
	
}
