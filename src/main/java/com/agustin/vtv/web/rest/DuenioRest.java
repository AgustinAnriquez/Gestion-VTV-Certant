package com.agustin.vtv.web.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agustin.vtv.domain.Duenio;
import com.agustin.vtv.services.DuenioService;


@RestController
@RequestMapping("/DuenioRest")
public class DuenioRest {

	@Autowired
	private DuenioService duenioService;
		
	@GetMapping()
	public List<Duenio> listarDuenios(){
		return duenioService.listarDuenios();
	}
	
	@PostMapping("/guardarDuenio")
	public Duenio guardarDuenio(@RequestBody Duenio duenio) {
		return duenioService.guardarDuenio(duenio);
	}
	
	@PutMapping("/editarDuenio/{dnipersona}")
	  public String editarDuenio(@PathVariable("dnipersona") String dnipersona, @RequestBody Duenio duenio) {
	    Optional<Duenio> duenioData = Optional.ofNullable(duenioService.encontrarDuenio(duenio));
	    if (duenioData.isPresent()) {
	      duenioService.guardarDuenio(duenio);
	      return "Propietario " + dnipersona + " actualizado";
	    } else {
	      return "Propietario no existe";
	    }
	  }

	@DeleteMapping("/eliminarDuenio/{dnipersona}")
	public String eliminarDuenio(@PathVariable("dnipersona") String dnipersona, Duenio duenio) {
		boolean ok = this.duenioService.eliminarDuenio(duenio);
		if (ok) {
			return "Se elimino el propietario " + dnipersona;
		}else {
			return "no se pudo eliminar el propietario con dni " + dnipersona;
		}

	}
	
}
