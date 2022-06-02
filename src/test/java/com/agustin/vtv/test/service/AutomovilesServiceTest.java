package com.agustin.vtv.test.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.agustin.vtv.domain.Automovil;
import com.agustin.vtv.domain.Duenio;
import com.agustin.vtv.domain.Marcas;
import com.agustin.vtv.domain.Modelos;
import com.agustin.vtv.domain.Version;
import com.agustin.vtv.services.AutomovilService;


public class AutomovilesServiceTest {
	
	AutomovilService automovilServiceMock = Mockito.mock(AutomovilService.class);
	
	Duenio propietario= new Duenio("41016682", "Agustin", "Anriquez", "comun");
	List<Version> listaVersionesAutomoviles =  new ArrayList<Version>();
	List<Modelos> listaModelosAutomoviles =  new ArrayList<Modelos>();
	Marcas marcaAutomovil = new Marcas(1, "Volskwaken", listaModelosAutomoviles);
	Modelos modelosAutomovil= new Modelos(1, "gol", marcaAutomovil, listaVersionesAutomoviles);
	Version versionesAutomoviles = new Version(1, "2001", modelosAutomovil);
	
	@Mock
	Automovil automovil = new Automovil("AAA123", marcaAutomovil, modelosAutomovil, versionesAutomoviles, propietario);
	
	@Test
	void listarAutomoviles() {
		Mockito.when(automovilServiceMock.listarAutomoviles()).thenReturn(Arrays.asList(automovil));
		assertNotNull(automovilServiceMock.listarAutomoviles());
	}
	
	@Test
	void guardarAutomovil() { 
		automovilServiceMock.guardarAutomovil(automovil);
	    verify(automovilServiceMock, times(1)).guardarAutomovil(automovil);
	}
	
	@Test
	void eliminarAutomovil() {
		automovilServiceMock.eliminarAutomovil(automovil);
	    verify(automovilServiceMock, times(1)).eliminarAutomovil(automovil);
	}
	
	@Test
	void encontrarAutomovil() {
		Mockito.when(automovilServiceMock.encontrarAutomovil(automovil)).thenReturn(automovil);
	}

}
