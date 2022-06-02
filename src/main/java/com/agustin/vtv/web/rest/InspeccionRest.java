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

import com.agustin.vtv.domain.Inspeccion;
import com.agustin.vtv.services.InspeccionService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/InspeccionRest")
public class InspeccionRest {
	
	@Autowired
	private InspeccionService inspeccionService;
	
	@GetMapping()
	public List<Inspeccion> listarInspecciones(){
		return inspeccionService.listarInspecciones();
	}
	
	@PostMapping("/guardarInspeccion")
	public Inspeccion guardarInspeccion(@RequestBody Inspeccion inspeccion) {
			return inspeccionService.guardarInspeccion(inspeccion);
	}
	
	@PutMapping("/editarInspeccion/{id}")
	  public String editarInspeccion(@PathVariable("id") Long id, @RequestBody Inspeccion inspeccion) {
	    Optional<Inspeccion> inspeccionData = Optional.ofNullable(inspeccionService.encontrarInspeccion(inspeccion));
	    if (inspeccionData.isPresent()) {
	    	inspeccionService.guardarInspeccion(inspeccion);
	    	return "Inspeccion " + id + " actualizada";
	    }else {
	    	return "Inspeccion no existe";
	    }
	  }
	
	@DeleteMapping("/eliminarInspeccion/{id}")
	public String eliminarInspeccion(@PathVariable("id") Long id, Inspeccion inspeccion) {
		boolean ok = this.inspeccionService.eliminarInspeccion(inspeccion);
		if (ok) {
			return "Se elimino el propietario " + id;
		}else {
			return "no se pudo eliminar el propietario con dni " + id;
		}

	}
	
	
}
