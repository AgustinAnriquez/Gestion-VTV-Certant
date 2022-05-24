package com.agustin.vtv.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agustin.vtv.domain.Inspector;
import com.agustin.vtv.services.InspectorService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

@RequestMapping("/listaInspectores")
public class ControladorInspectores {
	
	@Autowired
	private InspectorService inspectorService;
	
	@GetMapping("/")
	public String listaInspectores(Model model) {
		var inspectores = inspectorService.listarInspectores();
		model.addAttribute("inspectores", inspectores);
		return "listaInspectores";
	}
	
	@GetMapping("/agregarInspector")
	public String agregarInspector(Inspector inspector) {
		return "modificarInspector";
	}
	
	@PostMapping("/guardarInspector")
	public String guardarInspector(@Valid Inspector inspector, BindingResult result) {
		String dnipersona = String.valueOf(inspector.getDnipersona());
		if(dnipersona.length()==0) {
			FieldError error = new FieldError("inspector", "dnipersona", "El dni de la persona no puede ser 0");
			result.addError(error);
		}
		if(dnipersona.length()>8 || dnipersona.length()<7) {
			FieldError error = new FieldError("inspector", "dnipersona", "Los caracteres del dni deben ser 7 como minimo y 8 como maximo");
			result.addError(error);
		}
		if(inspector.getLegajo().length()>6 || inspector.getLegajo().length()<6) {
			FieldError error = new FieldError("inspector", "legajo", "El legajo debe contener 6 caracteres");
			result.addError(error);
		}
		if(result.hasErrors()) {
			return "modificarInspector";
		}
		inspectorService.guardarInspectores(inspector);
		return "redirect:/listaInspectores/";
	}
	
	@GetMapping("/editarInspector/{dnipersona}")
	public String editarInspector(Inspector inspector, Model model) {
		inspector = inspectorService.encontrarInspector(inspector);
		model.addAttribute("inspector", inspector);
		return "modificarInspector";
	}
	@GetMapping("/eliminarInspector/{dnipersona}")
	public String eliminarInspector(Inspector inspector) {
		inspectorService.eliminarInspector(inspector);
		return "redirect:/listaInspectores/";
	}
	
}
