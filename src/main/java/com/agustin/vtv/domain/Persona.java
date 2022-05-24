package com.agustin.vtv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @Column(name = "dnipersona", unique = true, nullable = false)
    @NotNull
	private long dnipersona;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
    
    public Persona() {}
  
    public Persona(Long dnipersona, String nombre, String apellido) {
		this.dnipersona=dnipersona;
		this.nombre = nombre;
		this.apellido = apellido;
	}


	public Long getDnipersona() {
		return dnipersona;
	}
    
	public void setDnipersona(Long dnipersona) {
		this.dnipersona = dnipersona;
	}

	@Column(name = "nombre", length = 50, nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "apellido", length = 50)
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
