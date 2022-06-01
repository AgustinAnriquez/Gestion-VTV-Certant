package com.agustin.vtv.test.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.agustin.vtv.domain.Duenio;
import com.agustin.vtv.services.DuenioService;

public class DuenioServiceTest {
	
	DuenioService duenioServiceMock = Mockito.mock(DuenioService.class);
	
	@Mock
	Duenio propietario= new Duenio((long) 41016682, "Agustin", "Anriquez", "comun");
	
	@Test
	void listarDuenios() {
		Mockito.when(duenioServiceMock.listarDuenios()).thenReturn(Arrays.asList(propietario));
		assertNotNull(duenioServiceMock.listarDuenios());
	}
	
	@Test
	void guardarDuenio() {
		duenioServiceMock.guardarDuenio(propietario);
		verify(duenioServiceMock, times(1)).guardarDuenio(propietario);
	}
	
	@Test
	void eliminarDuenio() {
		duenioServiceMock.eliminarDuenio(propietario);
		verify(duenioServiceMock, times(1)).eliminarDuenio(propietario);
	}
	
	@Test
	void encontrarDuenio() {
		Mockito.when(duenioServiceMock.encontrarDuenio(propietario)).thenReturn(propietario);
	}
	
	
	
}

	
