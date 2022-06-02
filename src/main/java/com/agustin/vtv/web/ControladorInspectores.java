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
		if(inspectorService.encontrarInspector(inspector)!=null) {
			FieldError error = new FieldError("inspector", "dni", "Ya existe un inspector con ese dni");
			result.addError(error);
		}
		if(inspectorService.findByLegajo(inspector.getLegajo())!=null) {
			FieldError error = new FieldError("inspector", "legajo", "Ya existe un inspector con ese legajo");
			result.addError(error);
		}	
		if(result.hasErrors()) {
			return "modificarInspector";
		}
		inspectorService.guardarInspectores(inspector);
		return "redirect:/listaInspectores/";
	}
	
	@PostMapping("/guardarInspectorYaExistente")
	public String guardarInspectorYaExistente(@Valid Inspector inspector, BindingResult result) {
		if(result.hasErrors()) {
			return "editarInspector";
		}
		inspectorService.guardarInspectores(inspector);
		return "redirect:/listaInspectores/";
	}

	@GetMapping("/editarInspector/{dnipersona}")
	public String editarInspector(Inspector inspector, Model model) {
		inspector = inspectorService.encontrarInspector(inspector);
		model.addAttribute("inspector", inspector);
		return "editarInspector";
	}
	@GetMapping("/eliminarInspector/{dnipersona}")
	public String eliminarInspector(Inspector inspector) {
		inspectorService.eliminarInspector(inspector);
		return "redirect:/listaInspectores/";
	}
	
}
