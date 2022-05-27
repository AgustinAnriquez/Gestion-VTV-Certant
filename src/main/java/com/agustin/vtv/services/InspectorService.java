package com.agustin.vtv.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.agustin.vtv.domain.Inspector;

public interface InspectorService {
	
	public List<Inspector> listarInspectores();
	
	public Inspector findByLegajo(@Param("legajo") String legajo);
	
	public void guardarInspectores(Inspector inspector);
	
	public void eliminarInspector(Inspector inspector);
	
	public Inspector encontrarInspector(Inspector inspector);
	
}
