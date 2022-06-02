package com.agustin.vtv.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.agustin.vtv.domain.Inspector;

public interface InspectorService {
	
	public List<Inspector> listarInspectores();
	
	public Inspector findByLegajo(@Param("legajo") String legajo);
	
	public Inspector guardarInspectores(Inspector inspector);
	
	public boolean eliminarInspector(Inspector inspector);
	
	public Inspector encontrarInspector(Inspector inspector);
	
}
