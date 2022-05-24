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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marcas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@OneToMany(mappedBy="marca", cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	private List<Modelos> modelos = new ArrayList<>();

	public Marcas() {
	}
	
	public Marcas(Integer id, String nombre, List<Modelos> modelos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.modelos = modelos;
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

	public List<Modelos> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelos> modelos) {
		this.modelos = modelos;
	}

}