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

import com.agustin.vtv.domain.Inspector;
import com.agustin.vtv.services.InspectorService;

@RestController
@RequestMapping("/InspectorRest")
public class InspectorRest {
	
	@Autowired
	private InspectorService inspectorService;
	
	@GetMapping()
	public List<Inspector> listarInspectores(){
		return inspectorService.listarInspectores();
	}
	
	@PostMapping("/guardarInspector")
	public Inspector guardarInspector(@RequestBody Inspector inspector) {
		return inspectorService.guardarInspectores(inspector);
	}
	
	@PutMapping("/editarInspector/{dnipersona}")
	  public String editarInspector(@PathVariable("dnipersona") String dnipersona, @RequestBody Inspector inspector) {
	    Optional<Inspector> inspectorData = Optional.ofNullable(inspectorService.encontrarInspector(inspector));
	    if (inspectorData.isPresent()) {
	    	inspectorService.guardarInspectores(inspector);
	    	return "Inspector " + dnipersona + " actualizado";
	    } else {
	      return "Inspector no existe";
	    }
	  }
	
	@DeleteMapping("/eliminarInspector/{dnipersona}")
	public String eliminarInspector(@PathVariable("dnipersona") String dnipersona, Inspector inspector) {
		boolean ok = this.inspectorService.eliminarInspector(inspector);
		if (ok) {
			return "Se elimino el inspector " + dnipersona;
		}else {
			return "no se pudo eliminar el inspector con dni " + dnipersona;
		}

	}
}
