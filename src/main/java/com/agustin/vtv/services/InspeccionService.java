package com.agustin.vtv.services;

import java.util.List;

import com.agustin.vtv.domain.Inspeccion;

public interface InspeccionService {
	
	public List<Inspeccion> listarInspecciones();
	
	public void guardarInspeccion(Inspeccion inpeccion);
	
	public void eliminarInspeccion(Inspeccion inspeccion);
	
	public Inspeccion encontrarInspeccion(Inspeccion inspeccion);
	
}
