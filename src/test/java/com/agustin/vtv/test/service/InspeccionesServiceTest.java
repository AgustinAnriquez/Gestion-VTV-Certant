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
import com.agustin.vtv.domain.Inspeccion;
import com.agustin.vtv.domain.Inspector;
import com.agustin.vtv.domain.Marcas;
import com.agustin.vtv.domain.Modelos;
import com.agustin.vtv.domain.Version;
import com.agustin.vtv.services.InspeccionService;

public class InspeccionesServiceTest {

	
	InspeccionService inspeccionServiceMock = Mockito.mock(InspeccionService.class);
	
	private Inspector inspector= new Inspector((long) 40122345, "Juan", "Lopez", "AAAAAA");
	private Duenio propietario= new Duenio((long) 41016682, "Agustin", "Anriquez", "comun");
	private List<Version> listaVersionesAutomoviles =  new ArrayList<Version>();
	private List<Modelos> listaModelosAutomoviles =  new ArrayList<Modelos>();
	private Marcas marcaAutomovil = new Marcas(1, "Volskwaken", listaModelosAutomoviles);
	private Modelos modelosAutomovil= new Modelos(1, "gol", marcaAutomovil, listaVersionesAutomoviles);
	private Version versionesAutomoviles = new Version(1, "2001", modelosAutomovil);
	private Automovil automovil = new Automovil("AAA123", marcaAutomovil, modelosAutomovil, versionesAutomoviles, propietario);
	
	@Mock
	Inspeccion inspeccion = new Inspeccion("2022-05-09", "apto", inspector, propietario, automovil);

	@Test
	void listarInspeccion() {
		Mockito.when(inspeccionServiceMock.listarInspecciones()).thenReturn(Arrays.asList(inspeccion));
		assertNotNull(inspeccionServiceMock.listarInspecciones());
	}
	
	@Test
	void guardarInspeccion() {
		inspeccionServiceMock.guardarInspeccion(inspeccion);
	    verify(inspeccionServiceMock, times(1)).guardarInspeccion(inspeccion);
	}
	
	@Test
	void eliminarInspeccion() {
		inspeccionServiceMock.eliminarInspeccion(inspeccion);
	    verify(inspeccionServiceMock, times(1)).eliminarInspeccion(inspeccion);;
	}
	
	@Test
	void encontrarInspeccion() {
		Mockito.when(inspeccionServiceMock.encontrarInspeccion(inspeccion)).thenReturn(inspeccion);
	}
	
}
