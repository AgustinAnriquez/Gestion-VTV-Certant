package com.agustin.vtv.domain.test;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;

import com.agustin.vtv.domain.Duenio;

public class DueniosTest {
	 
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	 
	@Test
	public void testDuenioEmpty() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio());
	        assertEquals(6, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testDuenioDniMenor() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio( "100000", "Agustin", "Anriquez", "comun"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testDuenioDniMayor() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio( "111100000", "Agustin", "Anriquez", "comun"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testDuenioDniVacio() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio( null, "Agustin", "Anriquez", "comun"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testDuenioNombreVacio() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio( "41016682", "", "Anriquez", "comun"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testDuenioNombreNulo() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio( "41016682", null, "Anriquez", "comun"));
	        assertEquals(2, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testDuenioApellidoVacio() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio( "41016682", "Agustin", "", "comun"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testDuenioApellidoNulo() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio( "41016682", "Agustin", null, "comun"));
	        assertEquals(2, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testDuenioTipoNulo() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio( "41016682", "Agustin", "Anriquez", null));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testDuenioTipoInvalido() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio( "41016682", "Agustin", "Anriquez", "ss"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testDuenioTiposValidos1() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio( "41016682", "Agustin", "Anriquez", "comun"));
	        assertEquals(0, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	@Test
	public void testDuenioTiposValidos2() {
	    Set<ConstraintViolation<Duenio>> violations = validator.validate(new Duenio("41016682", "Agustin", "Anriquez", "exento"));
	        assertEquals(0, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	
	
	
	
	


}
