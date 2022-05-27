 package com.agustin.vtv.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agustin.vtv.domain.Automovil;
import com.agustin.vtv.domain.Duenio;
import com.agustin.vtv.domain.Marcas;
import com.agustin.vtv.domain.Modelos;
import com.agustin.vtv.services.AutomovilService;
import com.agustin.vtv.services.DuenioService;
import com.agustin.vtv.services.MarcaAutomovilService;
import com.agustin.vtv.services.ModeloAutomovilService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

@RequestMapping("/listaAutomoviles")
public class ControladorAutomoviles {
	
	@Autowired
	private AutomovilService automovilService;
	
	@Autowired
	private DuenioService duenioService;
	
	@Autowired
	private MarcaAutomovilService marcaAutomovilService;
	
	@Autowired
	private ModeloAutomovilService modeloAutomovilService;
	
	@GetMapping("/")
	public String listaAutomoviles(Model model) {
		var automoviles = automovilService.listarAutomoviles();
		model.addAttribute("automoviles", automoviles);
		return "listaAutomoviles";
	}
	
	@GetMapping("/agregarAutomovil")
	public String agregarAutomovil(Automovil automovil,  Model model) {
		List<Duenio> listaDeDuenios = duenioService.listarDuenios();
		model.addAttribute("propietario", listaDeDuenios);
		return "modificarAutomovil";
	}
	
	@PostMapping("/guardarAutomovil")
	public String guardarAutomovil(@Valid Automovil automovil, BindingResult result, Model model) {
		
		if (automovilService.encontrarAutomovil(automovil) != null) {
			FieldError error = new FieldError("automovil", "dominio", "Ya existe automovil cargado con esa patente");
			result.addError(error);
		}
		if (automovil.getMarca() == null) {
			FieldError error = new FieldError("automovil", "marca", "seleccione marca por favor");
			result.addError(error);
		}
		if (automovil.getModelo() == null) {
			FieldError error = new FieldError("automovil", "modelo", "seleccione modelo por favor");
			result.addError(error);
		}
		if (automovil.getVersion() == null) {
			FieldError error = new FieldError("automovil", "version", "seleccione version por favor");
			result.addError(error);
		}
		if (result.hasErrors()) {
			List<Duenio> listaDeDuenios = duenioService.listarDuenios();
			model.addAttribute("propietario", listaDeDuenios);
			return "modificarAutomovil";
		}
		automovilService.guardarAutomovil(automovil);
		return "redirect:/listaAutomoviles/";
	}
	
	@PostMapping("/guardarAutomovilYaExistente")
	public String guardarAutomovilYaExistente(@Valid Automovil automovil, BindingResult result) {
		if(result.hasErrors()) {
			return "editarDuenio";
		}
		automovilService.guardarAutomovil(automovil);
		return "redirect:/listaAutomoviles/";
	}
	
	@GetMapping("/editarAutomovil/{dominio}")
	public String editarAutomovil(Automovil automovil, Model model) {
		List<Duenio> listaDeDuenios = duenioService.listarDuenios();
		model.addAttribute("propietario", listaDeDuenios);
		automovil = automovilService.encontrarAutomovil(automovil);
		model.addAttribute("automovil", automovil);
		return "editarAutomovil";
	}
	@GetMapping("/eliminarAutomovil/{dominio}")
	public String eliminarAutomovil(Automovil automovil) {
		automovilService.eliminarAutomovil(automovil);
		return "redirect:/listaAutomoviles/";
	}
	
	@RequestMapping("/listaMarcaAutomoviles")
	@ResponseBody
	public List<Marcas> listaDeMarcas(){
		List<Marcas> lista = marcaAutomovilService.listarMarcaAutomoviles();
        return lista;
	}
	
	@RequestMapping("/listaModeloAutomoviles")
	@ResponseBody
	public List<Modelos> listaDeModelos(){
		List<Modelos> lista = modeloAutomovilService.listarModeloAutomoviles();
        return lista;
	}
	
}
