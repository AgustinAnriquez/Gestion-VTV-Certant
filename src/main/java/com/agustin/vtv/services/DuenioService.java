package com.agustin.vtv.services;

import java.util.List;

import com.agustin.vtv.domain.Duenio;

public interface DuenioService {
	
	public List<Duenio> listarDuenios();
	
	public Duenio guardarDuenio(Duenio duenio);
	
	public boolean eliminarDuenio(Duenio duenio);
	
	public Duenio encontrarDuenio(Duenio duenio);
	
}
