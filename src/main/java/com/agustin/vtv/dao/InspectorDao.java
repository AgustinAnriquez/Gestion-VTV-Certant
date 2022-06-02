package com.agustin.vtv.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.agustin.vtv.domain.Inspector;

public interface InspectorDao extends CrudRepository<Inspector, String>{
	@Query("SELECT i FROM Inspector i WHERE i.legajo = (:legajo)")
	public abstract Inspector findByLegajo(@Param("legajo") String legajo);
}
