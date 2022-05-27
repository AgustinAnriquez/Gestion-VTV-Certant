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

import com.agustin.vtv.domain.Duenio;
import com.agustin.vtv.services.DuenioService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

@RequestMapping("/listaDuenios")
public class ControladorDuenios {
	
	@Autowired
	private DuenioService duenioService;
	
		
	@GetMapping("/")
	public String listaDuenios(Model model) {
		var duenios = duenioService.listarDuenios();
		model.addAttribute("duenios", duenios);
		return "listaDuenios";
	}
	
	@GetMapping("/agregarDuenio")
	public String agregarDuenio(Duenio duenio) {
		return "modificarDuenio";
	}
	
	@PostMapping("/guardarDuenio")
	public String guardarDuenio(@Valid Duenio duenio, BindingResult result) {
		if(duenio.getDnipersona()==null) {
			FieldError error = new FieldError("duenio", "dnipersona", "El dni no puede estar vacio");
			result.addError(error);
		}else {
			if(duenioService.encontrarDuenio(duenio)!=null) {
				FieldError error = new FieldError("duenio", "dnipersona", "Ya existe un propietario con ese dni");
				result.addError(error);
			}
		}		
		if(result.hasErrors()) {
			return "modificarDuenio";
		}
		duenioService.guardarDuenio(duenio);
		return "redirect:/listaDuenios/";
	}
	
	@PostMapping("/guardarDuenioYaExistente")
	public String guardarDuenioYaExistente(@Valid Duenio duenio, BindingResult result) {
		if(result.hasErrors()) {
			return "editarDuenio";
		}
		duenioService.guardarDuenio(duenio);
		return "redirect:/listaDuenios/";
	}
	
	@GetMapping("/editarDuenio/{dnipersona}")
	public String editarDuenio(Duenio duenio, Model model) {
		duenio = duenioService.encontrarDuenio(duenio);
		model.addAttribute("duenio", duenio);
		return "editarDuenio";
	}
	
	
	@GetMapping("/eliminarDuenio/{dnipersona}")
	public String eliminarDuenio(Duenio duenio) {
		duenioService.eliminarDuenio(duenio);
		return "redirect:/listaDuenios/";
	}
	
}