package com.agustin.vtv.services;

import java.util.List;

import com.agustin.vtv.domain.Inspeccion;

public interface InspeccionService {
	
	public List<Inspeccion> listarInspecciones();
	
	public Inspeccion guardarInspeccion(Inspeccion inpeccion);
	
	public boolean eliminarInspeccion(Inspeccion inspeccion);
	
	public Inspeccion encontrarInspeccion(Inspeccion inspeccion);
	
}
