package com.agustin.vtv.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "duenio")
@PrimaryKeyJoinColumn(referencedColumnName = "dnipersona")
public class Duenio extends Persona{
    
    private String tipo; 
    
	public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
