package com.agustin.vtv.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "modelos")
public class Modelos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="marca_id")
	@JsonIgnore
	private Marcas marca;
	
	@OneToMany(mappedBy="modelo", cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	private List<Version> versiones = new ArrayList<>();
	
	public Modelos() {
	}

	public Modelos(Integer id, String nombre, Marcas marca, List<Version> versiones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.versiones=versiones;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	public List<Version> getVersiones() {
		return versiones;
	}

	public void setVersiones(List<Version> versiones) {
		this.versiones = versiones;
	}

	
	
}