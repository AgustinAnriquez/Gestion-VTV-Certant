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
		String dnipersona = String.valueOf(duenio.getDnipersona());
		if(dnipersona.length()==0) {
			FieldError error = new FieldError("duenio", "dnipersona", "El dni de la persona no puede ser 0");
			result.addError(error);
		}

		if(dnipersona.length()>8 || dnipersona.length()<7) {
			FieldError error = new FieldError("duenio", "dnipersona", "Los caracteres del dni deben ser 7 como minimo y 8 como maximo");
			result.addError(error);
		}
		if(result.hasErrors()) {
			return "modificarDuenio";
		}
		duenioService.guardarDuenio(duenio);
		return "redirect:/listaDuenios/";
	}
	
	@GetMapping("/editarDuenio/{dnipersona}")
	public String editarDuenio(Duenio duenio, Model model) {
		duenio = duenioService.encontrarDuenio(duenio);
		model.addAttribute("duenio", duenio);
		return "modificarDuenio";
	}
	
	@GetMapping("/eliminarDuenio/{dnipersona}")
	public String eliminarDuenio(Duenio duenio) {
		duenioService.eliminarDuenio(duenio);
		return "redirect:/listaDuenios/";
	}
	
}