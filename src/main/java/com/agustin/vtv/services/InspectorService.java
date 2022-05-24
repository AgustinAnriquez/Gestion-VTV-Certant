package com.agustin.vtv.services;

import java.util.List;

import com.agustin.vtv.domain.Inspector;

public interface InspectorService {
	
	public List<Inspector> listarInspectores();
	
	public void guardarInspectores(Inspector inspector);
	
	public void eliminarInspector(Inspector inspector);
	
	public Inspector encontrarInspector(Inspector inspector);
	
}
