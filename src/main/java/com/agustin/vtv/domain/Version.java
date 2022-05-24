package com.agustin.vtv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "version")
public class Version {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idversion;
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="modelo_id")
	@JsonIgnore
	private Modelos modelo;
	
	public Version() {
	}

	public Version(Integer idversion, String nombre, Modelos modelo) {
		super();
		this.idversion = idversion;
		this.nombre = nombre;
		this.modelo = modelo;
	}



	public Integer getIdversion() {
		return idversion;
	}



	public void setIdversion(Integer idversion) {
		this.idversion = idversion;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Modelos getModelo() {
		return modelo;
	}



	public void setModelo(Modelos modelo) {
		this.modelo = modelo;
	}
	
	
	
}
