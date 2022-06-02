package com.agustin.vtv.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="inspector")
@PrimaryKeyJoinColumn(referencedColumnName = "dnipersona")
public class Inspector extends Persona{
	
	@NotEmpty
	@NotNull
	@Size(min = 5, max = 6)
	private String legajo;

	public Inspector() {}
	
	public Inspector(String dnipersona, String nombre, String apellido, String legajo) {
		super(dnipersona, nombre, apellido);
		this.legajo = legajo;
	}



	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

}
