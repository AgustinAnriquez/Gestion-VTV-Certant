package com.agustin.vtv.web;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

import com.agustin.vtv.domain.Automovil;
import com.agustin.vtv.domain.Duenio;
import com.agustin.vtv.domain.Inspeccion;
import com.agustin.vtv.domain.Inspector;
import com.agustin.vtv.services.AutomovilService;
import com.agustin.vtv.services.DuenioService;
import com.agustin.vtv.services.InspeccionService;
import com.agustin.vtv.services.InspectorService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

@RequestMapping("/listaInspecciones")
public class ControladorInspecciones {
	
	@Autowired
	private InspeccionService inspeccionService;
	
	@Autowired
	private DuenioService duenioService;
	@Autowired
	private InspectorService inspectorService;
	@Autowired
	private AutomovilService automovilService;
	
	@GetMapping("/")
	public String listaInspecciones(Model model) {
		var inspecciones = inspeccionService.listarInspecciones();
		model.addAttribute("inspecciones", inspecciones);
		return "listaInspecciones";
	}
	
	@GetMapping("/agregarInspeccion")
	public String agregarInspeccion(Inspeccion inspeccion, Model model) {
		List<Duenio> listaDeDuenios = duenioService.listarDuenios();
		model.addAttribute("propietario", listaDeDuenios);
		List<Inspector> listaDeInspectores = inspectorService.listarInspectores();
		model.addAttribute("inspector", listaDeInspectores);
		List<Automovil> listaDeAutomoviles = automovilService.listarAutomoviles();
		model.addAttribute("automovil", listaDeAutomoviles);
		return "modificarInspeccion";
	}
	
	@PostMapping("/guardarInspeccion")
	public String guardarInspeccion(@Valid Inspeccion inspeccion, BindingResult result, Model model) {	
		
		if (ChronoUnit.MONTHS.between(inspeccion.getFecha(), LocalDate.now()) > 12){
			FieldError error = new FieldError("inspeccion", "fecha", "fecha invalida, solo se permite menores a 1 año");
			result.addError(error);
		}
		
		if (result.hasErrors()) {
			List<Duenio> listaDeDuenios = duenioService.listarDuenios();
			model.addAttribute("propietario", listaDeDuenios);
			List<Inspector> listaDeInspectores = inspectorService.listarInspectores();
			model.addAttribute("inspector", listaDeInspectores);
			List<Automovil> listaDeAutomoviles = automovilService.listarAutomoviles();
			model.addAttribute("automovil", listaDeAutomoviles);
			System.out.println("Error de ejecucion");
			return "modificarInspeccion";
		}
		inspeccionService.guardarInspeccion(inspeccion);
		return "redirect:/listaInspecciones/";
	}
	
	@GetMapping("/editarInspeccion/{idinspeccion}")
	public String editarInspeccion(Inspeccion inspeccion, Model model) {
		List<Duenio> listaDeDuenios = duenioService.listarDuenios();
		model.addAttribute("propietario", listaDeDuenios);
		List<Inspector> listaDeInspectores = inspectorService.listarInspectores();
		model.addAttribute("inspector", listaDeInspectores);
		List<Automovil> listaDeAutomoviles = automovilService.listarAutomoviles();
		model.addAttribute("automovil", listaDeAutomoviles);
		inspeccion = inspeccionService.encontrarInspeccion(inspeccion);
		model.addAttribute("inspeccion", inspeccion);
		return "modificarInspeccion";
	}
	
	@GetMapping("/eliminarInspeccion/{idinspeccion}")
	public String eliminarInspeccion(Inspeccion inspeccion) {
		inspeccionService.eliminarInspeccion(inspeccion);
		return "redirect:/listaInspecciones/";
	}	
	
}
