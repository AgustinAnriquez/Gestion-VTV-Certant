package com.agustin.vtv.test.web;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;

import com.agustin.vtv.domain.Inspector;

public class InspectoresTest {
	
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@Test
	public void testInspectorEmpty() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector());
	        assertEquals(7, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspectorDniNulo() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector(null, "Agustin", "Anriquez", "AAAAAA"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspectorDniMenor() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector((long) 111111, "Agustin", "Anriquez", "AAAAAA"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspectorNombreVacio() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector((long) 41016682, "", "Anriquez", "AAAAAA"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspectorNombreNulo() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector((long) 41016682, null, "Anriquez", "AAAAAA"));
	        assertEquals(2, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspectorApellidoVacio() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector((long) 41016682, "Agustin", "", "AAAAAA"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspectorApellidoNulo() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector((long) 41016682, "Agustin", null, "AAAAA1"));
	        assertEquals(2, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspectorLegajoVacio() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector((long) 41016682, "Agustin", "Anriquez", ""));
	        assertEquals(2, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspectorLegajoNulo() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector((long) 41016682, "Agustin", "Anriquez", null));
	        assertEquals(2, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspectorLegajoMenor() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector((long) 41016682, "Agustin", "Anriquez", "AAAA"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	@Test
	public void testInspectorLegajoMayor() {
	    Set<ConstraintViolation<Inspector>> violations = validator.validate(new Inspector((long) 41016682, "Agustin", "Anriquez", "AAAAAAA"));
	        assertEquals(1, violations.size());
	        violations.forEach(v -> System.out.println(
	                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
	    }
	
	
	
}
