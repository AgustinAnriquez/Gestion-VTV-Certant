package com.agustin.vtv.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="inspector")
@PrimaryKeyJoinColumn(referencedColumnName = "dnipersona")
public class Inspector extends Persona{
	
	@NotEmpty
	private String legajo;

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

}
