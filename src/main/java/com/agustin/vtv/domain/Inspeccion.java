package com.agustin.vtv.domain;

import java.time.LocalDate;

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
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "inspeccion")
public class Inspeccion{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idinspeccion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message= "Ingrese fecha por favor")
	@PastOrPresent
	private LocalDate fecha;
	
	@NotEmpty
	@Pattern(regexp ="([a][p][t][o]|[c][o][n][d][i][c][i][o][n][a][l]|[r][e][c][h][a][z][a][d][o])", message="Estado solo puede ser apto/condicional/rechazado(ingrese todo en minusculas)")
	@NotNull
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "inspector", referencedColumnName="dnipersona")
	@NotNull
	private Inspector inspector;
	
	@ManyToOne
	@JoinColumn(name = "propietario", referencedColumnName="dnipersona")
	@NotNull
	private Duenio propietario;
	
	@ManyToOne
	@JoinColumn(name = "automovil", referencedColumnName="dominio")
	@NotNull
	private Automovil automovil;
	
	public Inspeccion() {}
	
	public Inspeccion(LocalDate fecha, String estado, Inspector inspector, Duenio propietario, Automovil automovil) {
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
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
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
