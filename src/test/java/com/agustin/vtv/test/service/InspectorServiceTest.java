package com.agustin.vtv.test.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.agustin.vtv.domain.Inspector;
import com.agustin.vtv.services.InspectorService;

public class InspectorServiceTest {
	
	InspectorService inspectorServiceMock = Mockito.mock(InspectorService.class);
	
	@Mock
	Inspector inspector= new Inspector("5987385", "Beatriz", "Riquelme", "AAAAAA");
	
	@Test
	void listarInspectores() {
		Mockito.when(inspectorServiceMock.listarInspectores()).thenReturn(Arrays.asList(inspector));
		assertNotNull(inspectorServiceMock.listarInspectores());
	}
	
	@Test
	void guardarInspector() {
		inspectorServiceMock.guardarInspectores(inspector);
		verify(inspectorServiceMock, times(1)).guardarInspectores(inspector);
	}
	
	@Test
	void eliminarInspector() {
		inspectorServiceMock.eliminarInspector(inspector);
		verify(inspectorServiceMock, times(1)).eliminarInspector(inspector);
	}
	
	@Test
	void encontrarInspector() {
		Mockito.when(inspectorServiceMock.encontrarInspector(inspector)).thenReturn(inspector);
	}
	
	@Test
	void encontrarInspectorByLegajo() {
		Mockito.when(inspectorServiceMock.findByLegajo(inspector.getLegajo())).thenReturn(inspector);
	}
	
}
