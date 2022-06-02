package com.agustin.vtv.domain.test;

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
import com.agustin.vtv.domain.Marcas;
import com.agustin.vtv.domain.Modelos;
import com.agustin.vtv.domain.Version;

public class AutomovilesTest {

	
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	private List<Version> listaVersionesAutomoviles =  new ArrayList<Version>();
	private List<Modelos> listaModelosAutomoviles =  new ArrayList<Modelos>();
	private Marcas marcaAutomovil = new Marcas(1, "Volskwaken", listaModelosAutomoviles);
	private Modelos modelosAutomovil= new Modelos(1, "gol", marcaAutomovil, listaVersionesAutomoviles);
	private Version versionesAutomoviles = new Version(1, "2001", modelosAutomovil);
	private Duenio propietario = new Duenio( "41016682", "Agustin", "Anriquez", "comun");
	
	
	@Test
	public void testAutomovilesEmpty() {
	    Set<ConstraintViolation<Automovil>> violations = validator.validate(new Automovil());
	        assertEquals(3, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testAutomovilesDominioVacio() {
	    Set<ConstraintViolation<Automovil>> violations = validator.validate(new Automovil("", marcaAutomovil, modelosAutomovil, versionesAutomoviles, propietario));
	       assertEquals(2, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testAutomovilesDominioNulo() {
	    Set<ConstraintViolation<Automovil>> violations = validator.validate(new Automovil(null, marcaAutomovil, modelosAutomovil, versionesAutomoviles, propietario));
	        assertEquals(2, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testAutomovilesDominioFormatoInvalido() {
	    Set<ConstraintViolation<Automovil>> violations = validator.validate(new Automovil("A2Aa123", marcaAutomovil, modelosAutomovil, versionesAutomoviles, propietario));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testAutomovilesDominioFormatoValido1() {
	    Set<ConstraintViolation<Automovil>> violations = validator.validate(new Automovil("AAA123", marcaAutomovil, modelosAutomovil, versionesAutomoviles, propietario));
	        assertEquals(0, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testAutomovilesDominioFormatoValido2() {
	    Set<ConstraintViolation<Automovil>> violations = validator.validate(new Automovil("AA123AA", marcaAutomovil, modelosAutomovil, versionesAutomoviles, propietario));
	        assertEquals(0, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testAutomovilesPropietarioNulo() {
	    Set<ConstraintViolation<Automovil>> violations = validator.validate(new Automovil("AA123AA", marcaAutomovil, modelosAutomovil, versionesAutomoviles, null));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	
}
