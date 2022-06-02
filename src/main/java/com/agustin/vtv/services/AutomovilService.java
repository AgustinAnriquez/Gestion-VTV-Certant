package com.agustin.vtv.services;

import java.util.List;

import com.agustin.vtv.domain.Automovil;

public interface AutomovilService {
	
	public List<Automovil> listarAutomoviles();
	
	public Automovil guardarAutomovil(Automovil automovil);
	
	public boolean eliminarAutomovil(Automovil automovil);
	
	public Automovil encontrarAutomovil(Automovil automovil);
}
