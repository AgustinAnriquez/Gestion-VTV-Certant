package com.agustin.vtv.services;

import java.util.List;

import com.agustin.vtv.domain.Duenio;

public interface DuenioService {
	
	public List<Duenio> listarDuenios();
	
	public void guardarDuenio(Duenio duenio);
	
	public void eliminarDuenio(Duenio duenio);
	
	public Duenio encontrarDuenio(Duenio duenio);
	
}
