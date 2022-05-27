package com.agustin.vtv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo {
	
	@Id
	@Column(name = "dominio", unique = true, nullable = false)
	@NotEmpty
	@NotNull
	@Pattern(regexp="([A-Z]{2}[0-9]{3}[A-Z]{2}|[A-Z]{3}[0-9]{3})", message="formato patente invalido, formatos validos=AA111AA o AAA111")
	private String dominio;
	
	@ManyToOne
	@JoinColumn(name = "marca", referencedColumnName="id")
	private Marcas marca;
	
	@ManyToOne
	@JoinColumn(name = "modelo", referencedColumnName="id")
	private Modelos modelo;
	
	@ManyToOne
	@JoinColumn(name = "version", referencedColumnName="idversion")
	private Version version;
	
	@ManyToOne
	@JoinColumn(name = "propietario", referencedColumnName="dnipersona")
	@NotNull
	private Duenio propietario;
	
	public Vehiculo() {
	}
	
	public Vehiculo (String dominio, Marcas marca, Modelos modelo, Version version, Duenio propietario) {
		
		this.dominio = dominio;
		this.marca = marca;
		this.modelo = modelo;
		this.version = version;
		this.propietario = propietario;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	
	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	public Modelos getModelo() {
		return modelo;
	}

	public void setModelo(Modelos modelo) {
		this.modelo = modelo;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Duenio getPropietario() {
		return propietario;
	}

	public void setPropietario(Duenio propietario) {
		this.propietario = propietario;
	}
	
}
