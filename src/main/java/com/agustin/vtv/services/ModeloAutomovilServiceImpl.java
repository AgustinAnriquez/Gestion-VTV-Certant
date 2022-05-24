package com.agustin.vtv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agustin.vtv.dao.ModeloAutomovilDao;
import com.agustin.vtv.domain.Modelos;

@Service
public class ModeloAutomovilServiceImpl implements ModeloAutomovilService{

	@Autowired
	private ModeloAutomovilDao modeloAutomovilDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Modelos> listarModeloAutomoviles() {
		return (List<Modelos>) modeloAutomovilDao.findAll();
	}


}
