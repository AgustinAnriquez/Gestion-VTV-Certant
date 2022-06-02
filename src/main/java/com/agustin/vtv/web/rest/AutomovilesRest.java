package com.agustin.vtv.web.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agustin.vtv.domain.Automovil;
import com.agustin.vtv.services.AutomovilService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/AutomovilRest")
public class AutomovilesRest {
	
	@Autowired
	private AutomovilService automovilService;
		
	@GetMapping()
	public List<Automovil> listarAutomoviles(){
		return automovilService.listarAutomoviles();
	}
	
	@PostMapping("/guardarAutomovil")
	public Automovil guardarAutomovil(@RequestBody Automovil automovil) {
			return automovilService.guardarAutomovil(automovil);
	}
	
	@PutMapping("/editarAutomovil/{dominio}")
	  public String editarAutomovil(@PathVariable("dominio") String dominio, @RequestBody Automovil automovil) {
	    Optional<Automovil> automovilData = Optional.ofNullable(automovilService.encontrarAutomovil(automovil));
	    if (automovilData.isPresent()) {
	    	automovilService.guardarAutomovil(automovil);
	      return "Automovil " + dominio + " actualizado";
	    } else {
	      return "Automovil no existe";
	    }
	  }
	
	@DeleteMapping("/eliminarAutomovil/{dominio}")
	public String eliminarDuenio(@PathVariable("dominio") String dominio, Automovil automovil) {
		boolean ok = this.automovilService.eliminarAutomovil(automovil);
		if (ok) {
			return "Se elimino el propietario " + dominio;
		}else {
			return "no se pudo eliminar el propietario con dni " + dominio;
		}

	}
	
}
