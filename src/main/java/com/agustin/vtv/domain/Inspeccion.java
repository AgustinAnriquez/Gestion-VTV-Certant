package com.agustin.vtv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "inspeccion")
public class Inspeccion{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idinspeccion;
	
	@NotNull
	@NotEmpty
	private String fecha;
	
	@NotEmpty
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "inspector", referencedColumnName="dnipersona")
	private Inspector inspector;
	
	@ManyToOne
	@JoinColumn(name = "propietario", referencedColumnName="dnipersona")
	private Duenio propietario;
	
	@ManyToOne
	@JoinColumn(name = "automovil", referencedColumnName="dominio")
	private Automovil automovil;
	
	public Inspeccion() {}
	
	public Inspeccion(String fecha, String estado, Inspector inspector, Duenio propietario, Automovil automovil) {
		this.fecha = fecha;
		this.estado = estado;
		this.inspector = inspector;
		this.propietario = propietario;
		this.automovil = automovil;
	}

	public Long getIdinspeccion() {
		return idinspeccion;
	}

	public void setIdinspeccion(Long idinspeccion) {
		this.idinspeccion = idinspeccion;
	}
	
	@Column(name = "fecha")
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	public Duenio getPropietario() {
		return propietario;
	}

	public void setPropietario(Duenio propietario) {
		this.propietario = propietario;
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	
	
}
