package com.agustin.vtv.test.web;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;

import com.agustin.vtv.domain.Automovil;
import com.agustin.vtv.domain.Duenio;
import com.agustin.vtv.domain.Inspeccion;
import com.agustin.vtv.domain.Inspector;
import com.agustin.vtv.domain.Marcas;
import com.agustin.vtv.domain.Modelos;
import com.agustin.vtv.domain.Version;

public class InspeccionesTest {
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	private Inspector inspector= new Inspector((long) 40122345, "Juan", "Lopez", "AAAAAA");
	private Duenio propietario= new Duenio((long) 41016682, "Agustin", "Anriquez", "comun");
	private List<Version> listaVersionesAutomoviles =  new ArrayList<Version>();
	private List<Modelos> listaModelosAutomoviles =  new ArrayList<Modelos>();
	private Marcas marcaAutomovil = new Marcas(1, "Volskwaken", listaModelosAutomoviles);
	private Modelos modelosAutomovil= new Modelos(1, "gol", marcaAutomovil, listaVersionesAutomoviles);
	private Version versionesAutomoviles = new Version(1, "2001", modelosAutomovil);
	private Automovil automovil = new Automovil("AAA123", marcaAutomovil, modelosAutomovil, versionesAutomoviles, propietario);
	
	
	@Test
	public void testInspeccionEmpty() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion());
	        assertEquals(7, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspeccionFechaNula() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion(null, "apto", inspector, propietario, automovil));
	        assertEquals(2, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspeccionFechaFormatoInvalido() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion("05-09-2022", "apto", inspector, propietario, automovil));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspeccionEstadoNulo() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion("2022-05-09", null, inspector, propietario, automovil));
	        assertEquals(2, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspeccionEstadoInvalido() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion("2022-05-09", "asddas", inspector, propietario, automovil));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testInspeccionEstadosValidos1() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion("2022-05-09", "apto", inspector, propietario, automovil));
	        assertEquals(0, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testInspeccionEstadosValidos2() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion("2022-05-09", "condicional", inspector, propietario, automovil));
	        assertEquals(0, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testInspeccionEstadosValidos3() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion("2022-05-09", "rechazado", inspector, propietario, automovil));
	        assertEquals(0, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspeccionInspectorNulo() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion("2022-05-09", "rechazado", null, propietario, automovil));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testInspeccionPropietarioNulo() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion("2022-05-09", "rechazado", inspector, null, automovil));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testInspeccionAutomovilNulo() {
	    Set<ConstraintViolation<Inspeccion>> violations = validator.validate(new Inspeccion("2022-05-09", "rechazado", inspector, propietario, null));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	
}
