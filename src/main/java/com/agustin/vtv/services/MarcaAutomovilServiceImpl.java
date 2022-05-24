package com.agustin.vtv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agustin.vtv.dao.MarcaAutomovilDao;
import com.agustin.vtv.domain.Marcas;

@Service
public class MarcaAutomovilServiceImpl implements MarcaAutomovilService{

	@Autowired
	private MarcaAutomovilDao marcaAutomovilDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Marcas> listarMarcaAutomoviles() {
		return (List<Marcas>) marcaAutomovilDao.findAll();
	}

}
