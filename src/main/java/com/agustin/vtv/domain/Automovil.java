package com.agustin.vtv.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "automovil")
@PrimaryKeyJoinColumn(referencedColumnName = "dominio")
public class Automovil extends Vehiculo{
     
	public Automovil() {
		
	}
	
	public Automovil(String dominio, Marcas marca, Modelos modelo, Version version, Duenio propietario) {
		super(dominio, marca, modelo, version, propietario);
	}
	
}