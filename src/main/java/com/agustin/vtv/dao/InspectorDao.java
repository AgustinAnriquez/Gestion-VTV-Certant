package com.agustin.vtv.dao;

import org.springframework.data.repository.CrudRepository;

import com.agustin.vtv.domain.Inspector;

public interface InspectorDao extends CrudRepository<Inspector, Long>{
	
}
